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
	     * ����������,��������ָ�������ļ�Ŀ¼
	     * @param indexFilePath
	     */
	    public SearchInfo(String indexFilePath){
	        try {
	            directory = FSDirectory.open(new File(indexFilePath)); //ȷ�������ļ��洢��λ��
	            analyzer = new IKAnalyzer();  //����һ���ʷ����������������ʹ�õ���IKAnalyzer��Ҳ�����������ʷ�������
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * Ĭ�Ϲ���,ʹ��ϵͳĬ�ϵ�·����Ϊ����
	     */
	    public SearchInfo(){
	        this("/luence/index");
	    }
	    
	    
	    /**
	     * ��������
	     * Description��
	     * @author dennisit@163.com Apr 3, 2013
	     * @throws Exception
	     */
	    public void createIndex()throws Exception{
	    	
	    	 //IndexWriterConfig�Ƕ�indexWriter�����ã����а�����������������һ����Ŀǰ�İ汾���ڶ����Ǵʷ�������Analyzer��
	        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47,analyzer);
	        
	        //����IndexWriter�����������ļ���д�롣
	        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
	        indexWriter.deleteAll();
	        
	        //������ȡ�����������Ĵ洢
	        List<Product> list = GetDataFromDB();
	        for(int i=0; i<list.size(); i++){
	            Product product = list.get(i);
//	            System.out.println(product.getProductid()+" "+product.getBrand());
	           Document document = addDocument(product.getProductid(),product.getBrand(),product.getType(),product.getPrice(),product.getPhone(),product.getOther());
	            indexWriter.addDocument(document);//��document������뵽����������
	        }
	        
	        //�ر�IndexWriter���ύ��������
	        indexWriter.close();
	    }
	    

	    
	    /**�����ݿ��л����Ʒ��������������*/
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
				   rs = stmt.executeQuery(sql);//ִ��sql���
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
				   System.out.println("���ݲ�������");
				   e.printStackTrace();
			  }
			return list;
	    	
	    }
	    
	    /**
	     * 
	     * Description��
	     * @author dennisit@163.com Apr 3, 2013
	     * @param id
	     * @param title
	     * @param content
	     * @return
	     */
	    public Document addDocument(long productid, String brand, String type,double price,String phone,String other){
	        Document doc = new Document();
	        //Field.Index.NO ��ʾ������         
	        //Field.Index.ANALYZED ��ʾ�ִ�������         
	        //Field.Index.NOT_ANALYZED ��ʾ���ִ�������
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
	     * Description�� ��������
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
	     * Description������ID��������
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
	     * Description����ѯ
	     * @author dennisit@163.com Apr 3, 2013
	     * @param where ��ѯ����
	     * @param scoreDoc ��ҳʱ��
	     */
	    public List<Product> search(String[] fields,String keyword){
	        
	        IndexSearcher indexSearcher = null;
	        List<Product> result = new ArrayList<Product>();
	        
	        
	        try {
	            //�������Ĵ洢λ��
	        	IndexReader indexReader = DirectoryReader.open(directory);
	        	//����������
	            indexSearcher = new IndexSearcher(indexReader);

	            //����SQL�����йؼ��ֲ�ѯ
	            //������ѯ����������ʷ����������Լ���ѯ���ֶ�fileds�����ν����ģ�
	            //��ѯ�������һ�����ϣ�������SQL��Resultset��������ȡ���������
	            MultiFieldQueryParser queryParser =new MultiFieldQueryParser(Version.LUCENE_47, fields,analyzer);
	            Query query = queryParser.parse(keyword);
	            
//	            System.out.println(keyword);
//	            System.out.println(query.toString());
	            //���ؽ����ǰnumber����¼
	            TopDocs topDocs = indexSearcher.search(query, 10);
	            //��Ϣչʾ
	            int totalCount = topDocs.totalHits;
	            System.out.println("�������� "+totalCount+" ����¼");
	            
	            
	            //������ʾ
	            /*  
	                  ����������,ʹ�����Ľ��������ʾ
	                SimpleHTMLFormatter������������Ҫ�����Ĺؼ��ֵĸ�����ʽ
	                ������2�����췽��
	                1��SimpleHTMLFormatter()Ĭ�ϵĹ��췽��.������ʽ��<B>�ؼ���</B>
	                2��SimpleHTMLFormatter(String preTag, String postTag).������ʽ��preTag�ؼ���postTag
	             */
	            Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");    
	            /*
	                 QueryScorer
	                QueryScorer �����õļƷ������Ʒ����Ĺ��������ǽ�Ƭ������QueryScorerʹ�õ����Ǵ��û�����Ĳ�ѯ�еõ��ģ�
	                �����ԭʼ����ĵ��ʡ�����Ͳ�����ѯ����ȡ����һ�����Ӧ�ļ�Ȩ���ӣ�boost factor�������Ǽ�Ȩ��
	                Ϊ�˱���QueryScoereʹ�ã�������Բ�ѯ��ԭʼ��ʽ������д��
	                ���磬��ͨ�����ѯ��ģ����ѯ��ǰ׺��ѯ�Լ���Χ��ѯ �ȣ�������дΪBoolenaQuery����ʹ�õ��
	                �ڽ�Queryʵ�����ݵ�QueryScorer֮ǰ�����Ե���Query.rewrite (IndexReader)��������дQuery���� 
	             */
	            Scorer fragmentScorer = new QueryScorer(query);
	            Highlighter highlighter = new Highlighter(formatter,fragmentScorer);
	            Fragmenter fragmenter = new SimpleFragmenter(100);
	            /*    
	                Highlighter����Fragmenter��ԭʼ�ı��ָ�ɶ��Ƭ�Ρ�
	                      ���õ�SimpleFragmenter��ԭʼ�ı��ָ����ͬ��С��Ƭ�Σ�Ƭ��Ĭ�ϵĴ�СΪ100���ַ��������С�ǿɿ��Ƶġ�
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
	                //float score = scDoc.score; //���ƶ�
	                
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
