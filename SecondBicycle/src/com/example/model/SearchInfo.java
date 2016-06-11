package com.example.model;
import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser; 
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;




import DB.DBBean;
import entity.Product;


public class SearchInfo {
	 private Directory directory ;
	    private Analyzer analyzer ;
	    
	    /**
	     * 带参数构造,参数用来指定索引文件目录
	     * @param indexFilePath
	     */
	    public SearchInfo(String indexFilePath){
	        try {
	            directory = FSDirectory.open(new File(indexFilePath)); //确定索引文件存储的位置
	            analyzer = new IKAnalyzer();  //创建一个词法分析器，这里搭配使用的是IKAnalyzer，也可以是其他词法分析器
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 默认构造,使用系统默认的路径作为索引
	     */
	    public SearchInfo(){
	        this("/luence/index");
	    }
	    
	    
	    /**
	     * 创建索引
	     * Description：
	     * @author dennisit@163.com Apr 3, 2013
	     * @throws Exception
	     */
	    public void createIndex()throws Exception{
	    	
	    	 //IndexWriterConfig是对indexWriter的配置，其中包含了两个参数，第一个是目前的版本，第二个是词法分析器Analyzer。
	        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47,analyzer);
	        
	        //创建IndexWriter，进行索引文件的写入。
	        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
	        indexWriter.deleteAll();
	        
	        //内容提取，进行索引的存储
	        List<Product> list = GetDataFromDB();
	        for(int i=0; i<list.size(); i++){
	            Product product = list.get(i);
//	            System.out.println(product.getProductid()+" "+product.getBrand());
	           Document document = addDocument(product.getProductid(),product.getBrand(),product.getType(),product.getPrice(),product.getPhone(),product.getOther());
	            indexWriter.addDocument(document);//把document对象加入到索引创建中
	        }
	        
	        //关闭IndexWriter，提交创建内容
	        indexWriter.close();
	    }
	    

	    
	    /**从数据库中获得商品数据来建立索引*/
		public List GetDataFromDB()
	    {
	      	  Connection conn = null;
			  Statement stmt = null;
			  ResultSet rs = null;
			  String sql=null;
			  List<Product> list = new ArrayList<Product>();
			  try 
			  {
				   conn=DBBean.getConnection();
				   stmt = conn.createStatement();
				   sql = "select * from product;";
				   rs = stmt.executeQuery(sql);//执行sql语句
				   while(rs.next())
				   {
					   int id=rs.getInt("productid");
					   String brand=rs.getString("brand");
					   String type=rs.getString("type");
					   Double price=rs.getDouble("price");
					   String phone=rs.getString("phone");
					   String other=rs.getString("other");

//					   System.out.println(id+" "+brand);
				       list.add(new Product(id,brand,type,price,phone,other));
				   }
			  }
			  catch (SQLException e)
			  {
				   System.out.println("数据操作错误");
				   e.printStackTrace();
			  }
			return list;
	    	
	    }
	    
	    /**
	     * 
	     * Description：
	     * @author dennisit@163.com Apr 3, 2013
	     * @param id
	     * @param title
	     * @param content
	     * @return
	     */
	    public Document addDocument(long productid, String brand, String type,double price,String phone,String other){
	        Document doc = new Document();
	        //Field.Index.NO 表示不索引         
	        //Field.Index.ANALYZED 表示分词且索引         
	        //Field.Index.NOT_ANALYZED 表示不分词且索引
	        doc.add(new Field("productid",String.valueOf(productid),Field.Store.YES,Field.Index.NOT_ANALYZED));
	        doc.add(new Field("brand",brand,Field.Store.YES,Field.Index.ANALYZED));
	        doc.add(new Field("type",type,Field.Store.YES,Field.Index.ANALYZED));
	        doc.add(new Field("price",String.valueOf(price),Field.Store.YES,Field.Index.ANALYZED));
	        doc.add(new Field("phone",phone,Field.Store.YES,Field.Index.ANALYZED));
	        doc.add(new Field("other",other,Field.Store.YES,Field.Index.ANALYZED));
	        return doc;
	    }
	    
	    /**
	     * 
	     * Description： 更新索引
	     * @author dennisit@163.com Apr 3, 2013
	     * @param id
	     * @param title
	     * @param content
	     */
	    /*public void update(Integer id,String title, String content){
	        try {
	            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47,analyzer);
	            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
	            Document document = addDocument(id, title, content);
	            Term term = new Term("id",String.valueOf(id));
	            indexWriter.updateDocument(term, document);
	            indexWriter.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }*/
	    
	    /**
	     * 
	     * Description：按照ID进行索引
	     * @author dennisit@163.com Apr 3, 2013
	     * @param id
	     */
	    public void delete(Integer id){
	        try {
	            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47,analyzer);
	            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
	            Term term = new Term("id",String.valueOf(id));
	            indexWriter.deleteDocuments(term);
	            indexWriter.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 
	     * Description：查询
	     * @author dennisit@163.com Apr 3, 2013
	     * @param where 查询条件
	     * @param scoreDoc 分页时用
	     */
	    public List<Product> search(String[] fields,String keyword){
	        
	        IndexSearcher indexSearcher = null;
	        List<Product> result = new ArrayList<Product>();
	        
	        
	        try {
	            //打开索引的存储位置
	        	IndexReader indexReader = DirectoryReader.open(directory);
	        	//创建搜索器
	            indexSearcher = new IndexSearcher(indexReader);

	            //类似SQL，进行关键字查询
	            //创建查询器并设置其词法分析器，以及查询的字段fileds（传参进来的）
	            //查询结果返回一个集合，类似于SQL的Resultset，可以提取里面的内容
	            MultiFieldQueryParser queryParser =new MultiFieldQueryParser(Version.LUCENE_47, fields,analyzer);
	            Query query = queryParser.parse(keyword);
	            
//	            System.out.println(keyword);
//	            System.out.println(query.toString());
	            //返回结果集前number条记录
	            TopDocs topDocs = indexSearcher.search(query, 10);
	            //信息展示
	            int totalCount = topDocs.totalHits;
	            System.out.println("共检索出 "+totalCount+" 条记录");
	            
	            
	            //高亮显示
	            /*  
	                  创建高亮器,使搜索的结果高亮显示
	                SimpleHTMLFormatter：用来控制你要加亮的关键字的高亮方式
	                此类有2个构造方法
	                1：SimpleHTMLFormatter()默认的构造方法.加亮方式：<B>关键字</B>
	                2：SimpleHTMLFormatter(String preTag, String postTag).加亮方式：preTag关键字postTag
	             */
	            Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");    
	            /*
	                 QueryScorer
	                QueryScorer 是内置的计分器。计分器的工作首先是将片段排序。QueryScorer使用的项是从用户输入的查询中得到的；
	                它会从原始输入的单词、词组和布尔查询中提取项，并且基于相应的加权因子（boost factor）给它们加权。
	                为了便于QueryScoere使用，还必须对查询的原始形式进行重写。
	                比如，带通配符查询、模糊查询、前缀查询以及范围查询 等，都被重写为BoolenaQuery中所使用的项。
	                在将Query实例传递到QueryScorer之前，可以调用Query.rewrite (IndexReader)方法来重写Query对象 
	             */
	            Scorer fragmentScorer = new QueryScorer(query);
	            Highlighter highlighter = new Highlighter(formatter,fragmentScorer);
	            Fragmenter fragmenter = new SimpleFragmenter(100);
	            /*    
	                Highlighter利用Fragmenter将原始文本分割成多个片段。
	                      内置的SimpleFragmenter将原始文本分割成相同大小的片段，片段默认的大小为100个字符。这个大小是可控制的。
	             */
	            highlighter.setTextFragmenter(fragmenter);
	            
	            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
	            
	            for(ScoreDoc scDoc : scoreDocs){
	                Document  document = indexSearcher.doc(scDoc.doc);
	                Integer id = Integer.parseInt(document.get("productid"));
	                String brand = document.get("brand");
	                String type= document.get("type");
	                Double price = Double.parseDouble(document.get("price"));
	                String phone = document.get("phone");
	                String other = document.get("other");
	                //float score = scDoc.score; //相似度
	                
	                String lighterBrand = highlighter.getBestFragment(analyzer, "brand", brand);
	                if(null==lighterBrand){
	                    lighterBrand = brand;
	                }
	                
	                String lighterType = highlighter.getBestFragment(analyzer, "type", type);
	                if(null==lighterType){
	                    lighterType = type;
	                }
	                
	                String lighterOther = highlighter.getBestFragment(analyzer, "other", other);
	                if(null==lighterOther){
	                    lighterOther = other;
	                }
	                
	                Product product = new Product();
	                
	                product.setProductid(id);
	                product.setBrand(lighterBrand);
	                product.setType(lighterType);
	                product.setPrice(price);
	                product.setPhone(phone);
	                product.setOther(lighterOther);
	                
	                result.add(product);
	                           }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	        return result;
	    }

}
