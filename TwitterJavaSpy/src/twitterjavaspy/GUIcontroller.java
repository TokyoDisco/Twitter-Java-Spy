package twitterjavaspy;

import com.thoughtworks.xstream.XStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.Query.Unit;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import static twitterjavaspy.Globals.*;

public class GUIcontroller {

    static Object UserIDS;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GeoBtn;

    @FXML
    private TextArea historyWall;

    @FXML
    private Button SearchBtn1;

    @FXML
    private Button SearchBtn2;

    @FXML
    private PieChart PieChart1;

    @FXML
    private Label GeoLabel1;

    @FXML
    private MenuItem LangMenuAction10;

    @FXML
    private Label GeoLabel2;

    @FXML
    private SplitMenuButton LangMenu;

    @FXML
    private SplitMenuButton AreaSelect;

    @FXML
    private SplitMenuButton PieChartSet;

    @FXML
    private TextField LatText;

    @FXML
    private TextField LogText;

    @FXML
    private MenuItem AreaMenu2;

    @FXML
    private MenuItem AreaMenu3;

    @FXML
    private MenuItem AreaMenu1;

    @FXML
    private TextArea UserWall;

    @FXML
    private MenuItem LangMenuAction1;

    @FXML
    private MenuItem LangMenuAction2;

    @FXML
    private MenuItem LangMenuAction3;

    @FXML
    private MenuItem LangMenuAction4;

    @FXML
    private MenuItem LangMenuAction5;

    @FXML
    private MenuItem LangMenuAction6;

    @FXML
    private AnchorPane MainPanel;

    @FXML
    private MenuItem LangMenuAction7;

    @FXML
    private MenuItem LangMenuAction8;

    @FXML
    private TextField text1;

    @FXML
    private MenuItem LangMenuAction9;

    @FXML
    private TextArea TextWall1;

    @FXML
    private Label UniLabel;

    @FXML
    void initialize() throws InterruptedException {
        assert GeoBtn != null : "fx:id=\"GeoBtn\" was not injected: check your FXML file 'GUI.fxml'.";
        assert historyWall != null : "fx:id=\"historyWall\" was not injected: check your FXML file 'GUI.fxml'.";
        assert SearchBtn1 != null : "fx:id=\"SearchBtn1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert SearchBtn2 != null : "fx:id=\"SearchBtn2\" was not injected: check your FXML file 'GUI.fxml'.";
        assert PieChart1 != null : "fx:id=\"PieChart1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert GeoLabel1 != null : "fx:id=\"GeoLabel1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction10 != null : "fx:id=\"LangMenuAction10\" was not injected: check your FXML file 'GUI.fxml'.";
        assert GeoLabel2 != null : "fx:id=\"GeoLabel2\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenu != null : "fx:id=\"LangMenu\" was not injected: check your FXML file 'GUI.fxml'.";
        assert AreaSelect != null : "fx:id=\"AreaSelect\" was not injected: check your FXML file 'GUI.fxml'.";
        assert PieChartSet != null : "fx:id=\"PieChartSet\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LatText != null : "fx:id=\"LatText\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LogText != null : "fx:id=\"LogText\" was not injected: check your FXML file 'GUI.fxml'.";
        assert AreaMenu2 != null : "fx:id=\"AreaMenu2\" was not injected: check your FXML file 'GUI.fxml'.";
        assert AreaMenu3 != null : "fx:id=\"AreaMenu3\" was not injected: check your FXML file 'GUI.fxml'.";
        assert AreaMenu1 != null : "fx:id=\"AreaMenu1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert UserWall != null : "fx:id=\"UserWall\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction1 != null : "fx:id=\"LangMenuAction1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction2 != null : "fx:id=\"LangMenuAction2\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction3 != null : "fx:id=\"LangMenuAction3\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction4 != null : "fx:id=\"LangMenuAction4\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction5 != null : "fx:id=\"LangMenuAction5\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction6 != null : "fx:id=\"LangMenuAction6\" was not injected: check your FXML file 'GUI.fxml'.";
        assert MainPanel != null : "fx:id=\"MainPanel\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction7 != null : "fx:id=\"LangMenuAction7\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction8 != null : "fx:id=\"LangMenuAction8\" was not injected: check your FXML file 'GUI.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert LangMenuAction9 != null : "fx:id=\"LangMenuAction9\" was not injected: check your FXML file 'GUI.fxml'.";
        assert TextWall1 != null : "fx:id=\"TextWall1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert UniLabel != null : "fx:id=\"UniLabel\" was not injected: check your FXML file 'GUI.fxml'.";

    

  
        
        
        
        //Twitter rate status
  
      ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        
      // configBuilder.setOAuthConsumerKey("XXXX");
       configBuilder.setOAuthConsumerSecret("XXXX");
       configBuilder.setOAuthAccessToken("XXXX");
       configBuilder.setOAuthAccessTokenSecret("XXXX");
       TwitterFactory tf = new TwitterFactory(configBuilder.build());
       Twitter twitter = tf.getInstance();
       LatText.setVisible(false);
       LogText.setVisible(false);
       GeoLabel1.setVisible(false);
       if (text1.getText()==null)
       {
           SearchBtn1.setDisable(true);
       }
       if (LatText.getText()==null || LogText.getText()==null)
       {
           
       }
        
        
//Language selection meun action set up    
        PieChart1.setVisible(false);
       LangMenu.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e1){
             SearchLang = ("en");
             historyWall.appendText("\n" + "Searching Language is : " + SearchLang + "\n") ;  
            
           }
           
       }) ;
        LangMenuAction1.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("pl");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
        
           LangMenuAction2.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("ja");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
      
      //Using area which display history of searches, this also notify which languge users searches in   
   
        
      
      
        LangMenuAction3.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("ru");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
        
          LangMenuAction4.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("ko");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
          
          
            LangMenuAction5.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("fr");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
            
            
              LangMenuAction6.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("es");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
              
              
              
                LangMenuAction7.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("de");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
                
                
                
                  LangMenuAction8.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("it");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
                  
                  
                    LangMenuAction9.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("pt");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
        
                    
                    
                    
                      LangMenuAction10.setOnAction(new EventHandler<ActionEvent>(){
           @Override public void handle(ActionEvent e2){
             SearchLang = ("zh-cn");
             historyWall.appendText("Searching Language is : " + SearchLang + "\n") ;  
           }
           
       }) ;
         
      
        if (SearchLang == null)
            { historyWall.appendText("Searching language is : any language" + "\n" );
            }
        else 
            { historyWall.appendText("Searching Language is : " + SearchLang + "\n");
            
            }
        
        
        AreaSelect.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e3){
             Radius = 5 ;  
            historyWall.appendText("Radius for GeoCode search is : " + Radius + "\n") ;  
            }
        });
        
        AreaMenu1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e3){
             Radius = 10 ;  
            historyWall.appendText("Radius for GeoCode search is : " + Radius + "\n") ;  
            }
        });
         
          AreaMenu2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e3){
             Radius = 25 ;  
            historyWall.appendText("Radius for GeoCode search is : " + Radius + "\n") ;  
            }
        });
          
           AreaMenu3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e3){
             Radius = 50 ;  
            historyWall.appendText("Radius for GeoCode search is : " + Radius + "\n") ;  
            }
        });
        
        
        
       
         GeoBtn.setOnAction(new EventHandler<ActionEvent>() {
         
             @Override
             public void handle(ActionEvent press)
             {
                if  ( GeoDataSearch == 0){ 
                    GeoDataSearch = 1 ; 
                    
                 LatText.setVisible(true);
                 LogText.setVisible(true);
                 GeoLabel1.setVisible(true);
                 GeoLabel2.setText("Search by geodata is : ON");     
                 historyWall.appendText("Searching by GeoData is now ON " + "\n" );
                }
                else 
                { GeoDataSearch = 0 ;
                 LatText.setVisible(false);
                 LogText.setVisible(false);
                 GeoLabel1.setVisible(false);
                 GeoLabel2.setText("Search by geodata is : OFF");   
                 historyWall.appendText("Searching by GeoData is now OFF " + "\n");
                }
                
             }
         });
 
                 historyWall.appendText("Rate exceeded : restart app and try again later" + "\n");
             Map<String, RateLimitStatus> statusMap;
                try {
                    statusMap = twitter.getRateLimitStatus();
                 for (String str : statusMap.keySet()) {
              RateLimitStatus status = statusMap.get(str);
              historyWall.appendText("Limit type " + str + "\n" + "; Limit:" + status.getLimit() +  "\n" + " ; minutes  until reset: " + (status.getSecondsUntilReset()/60) + "\n"  );
              
          }
                } catch (TwitterException ex1) {
                    
                 historyWall.appendText("Error try to restart app");
                }
         
            
         
         
         
    //button actions
        SearchBtn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event1) {
              String keyword = text1.getText();
               int i = 0 ;
              if (keyword == null )
              {
                  historyWall.appendText("Enter Keyword you want to search.");
                  
              }
        
        long startTime = System.currentTimeMillis() ;
       
          
                    
          
                    Query query = new Query (keyword);      
        query.setResultType(Query.ResultType.mixed);
        
        //Search numbers of Queary <set up globaly to 100> 
       query.setCount(QueryCount);

        //Language of tweets
        query.setLang(SearchLang);
        if (GeoDataSearch == 1)
        {
            Double LatDouble = Double.valueOf(LatText.getText());
            Double LogDouble = Double.valueOf(LogText.getText());
            QueryCount = 100 ; 
            numResults = 10 ; 
           
                   
            
            
             GeoLocation place1 = new GeoLocation (LatDouble, LogDouble);
             
        
         query.setGeoCode(place1 , Radius , Unit.valueOf("km"));
         historyWall.appendText(("Searching set for location  : " + place1 + ""
                 + "\n" ));
        }
            

        
         HashMap<Long, Boolean> tweetIDMap = new HashMap();
         HashMap<String, Double> wordCount = new HashMap();
         HashMap<Long,Boolean> UserMap = new HashMap();
         HashMap<String, Long> NameMap = new HashMap();
         HashMap<Long, ArrayList<Long>> followerMap = new HashMap();
               
        
         
          QueryResult result;
        
        try{
            result = twitter.search(query);
            TextWall1.clear();
         
            while (result.getCount() <= QueryCount  && tweetIDMap.size() <= numResults  )    {
                
            //&& tweetIDMap.size() <= numResults
            //Get the results
                long minID = -1;
            
            List<Status> tweets = result.getTweets();
       
            //Print out the results
             for (Status tweet : tweets) {
               
                     
                    //Track min id so we can get the next 'page'
                    if(minID == -1 || tweet.getId() < minID)
                        minID = tweet.getId();

                    //Store ID in hash map to keep track of number of tweets
                    tweetIDMap.put(tweet.getId(), Boolean.TRUE);
                    
                 
                  String userName = tweet.getUser().getName();
                  long userId = tweet.getUser().getId();
                
                      if ((tweetIDMap.size() + 1)  % 15 == 0)
                    { historyWall.appendText("sleeping....");
                       System.out.println("System is sleeping due limit");
                      
                       Thread.sleep(16 * 60 * 1000) ;
                    }
                    
                  
                  
                  
                  
                  
                  
                  Date creationDate = tweet.getCreatedAt();
                    String tweetText = tweet.getText();
                    GeoLocation tweetGeo = tweet.getGeoLocation();
                    Place tweetPlace = tweet.getPlace();
                    String tweetGeoInfo ;
                    
                         UserMap.put(tweet.getUser().getId(),true);
                    NameMap.put(tweet.getUser().getName(), tweet.getUser().getId());
//                
    
                    



                    IDs ids = twitter.getFollowersIDs(userId, -1);
                    followerMap.put(userId, new ArrayList());
                    long[]  followerIdArray = ids.getIDs();
                    
                
                    
                    
                    
                   for (int y = 0 ; y <followerIdArray.length; ++y)
               {
                       long key = followerIdArray[y];
                        if(followerMap.containsKey(key))
                          {
                              followerMap.get(key).add(userId);
                          }
               }
//                         
                    
                    
                  
                            
                      
                            String infoTweet = ("Tweet created by : " + userName +  "(" + userId + ") on date " + creationDate );
                            String TweetContent =("Tweet text: " +  "\n" + tweetText + "\n");
                             if (tweetGeo == null)
                            { tweetGeoInfo = ("Geotag was not used" + "\n");
                            }
                              else 
                              {
                           
                             tweetGeoInfo = ("Tweet from:  " + tweetPlace.getFullName() + " in " + tweetPlace.getCountry() + "\n" +  tweetGeo + "\n" ) ;
                            } 
                            TextWall1.appendText(infoTweet + "\n" + TweetContent + "\n" + tweetGeoInfo + "\n"  );       
                                UserWall.appendText("User : " + userId + " ( " +  userName + " ) " + " has " + followerIdArray.length + " followers " + "\n" );
                            
                              
                String[] statusSplitOnSpace = tweetText.split(" ");
                for(String wordInStatus : statusSplitOnSpace){
                         if (!wordCount.containsKey(wordInStatus)) {
                wordCount.put(wordInStatus, 1.0);
                
            } else 
                         {             
                wordCount.put(wordInStatus, wordCount.get(wordInStatus)+1);
            }
             }
             }
           
             query.setMaxId(minID-1);
             result = twitter.search(query);
       
            
            
                        if (  i % 15 == 0)
                        {   
                        }
             
               
                 i = i + 1 ; 
              
            }
            
            String uniTweets = Integer.toString(tweetIDMap.size());
            String uniUser = Integer.toString(UserMap.size());
            
            
            
          
           
            TextWall1.appendText("Searched for : " + keyword + "\n");
            TextWall1.appendText("Unique tweets for : " + keyword + " " + uniTweets + "\n");
            UserWall.appendText("Unique user in this area : " + uniUser + "\n");
            UserWall.appendText("To get followers of this users click button above - if there are above 15 user it can take a lot of time");
            
              
               
     for(Entry<String,Double> wordHit : wordCount.entrySet()){
        System.out.println("Word (" + wordHit.getKey() + ") was found " + wordHit.getValue() + " times.");
    
     
                   
     }                 
             //list of unnecessery "words" in English
             wordCount.remove("-");
             wordCount.remove("RT");
             wordCount.remove("the");
             wordCount.remove("of");
             wordCount.remove("is");
             wordCount.remove("and");
             wordCount.remove("be");
             wordCount.remove("from");
             wordCount.remove("to");
             wordCount.remove("a");
             wordCount.remove("an");
             wordCount.remove("") ;
             
             //Sorting out 10 most used orders
     Map <String, Double> wordCountSort =  
            (Map<String, Double>) wordCount.entrySet().stream()
           //   .sorted(reverseOrder(Map.Entry.comparingByValue()))
              .sorted(Map.Entry.comparingByValue())
           //  it's limits whole map to last ten which are most used words 
            .skip((wordCount.size())-10) 
         .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)) ;
          //                      (e1, e2) -> e1, LinkedHashMap::new)) ;
            
          
         
            System.out.println("Order : " + wordCountSort);
            TextWall1.appendText("The 10 most used words are : " + wordCountSort);
            
            // Convert map to array of strings and doubles
            Collection<String> Words = wordCountSort.keySet();
            Collection<Double> Counts = wordCountSort.values();
            Collection<Long> UsersId = UserMap.keySet();
           
            String[] WordsData =  Words.toArray(new String[Words.size()]); 
            Double[] CountData = Counts.toArray(new Double[Words.size()]);
            Long[] UserIDS = UsersId.toArray(new Long[UsersId.size()]);
           
            
           
            //Set up for Pie Chart
            
            Double[] NumData = new Double [wordCountSort.size()];
            for (int y = 0; y < 10 ; y++){
                NumData[y] = wordCountSort.get(y);
            }
           
            
            ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data ( WordsData[0], CountData[0]),
            new PieChart.Data ( WordsData[1], CountData[1]), 
            new PieChart.Data ( WordsData[2], CountData[2] ),
            new PieChart.Data ( WordsData[3], CountData[3]),
            new PieChart.Data ( WordsData[4], CountData[4]), 
            new PieChart.Data ( WordsData[5], CountData[5] ),
            new PieChart.Data ( WordsData[6], CountData[6]),
            new PieChart.Data ( WordsData[7], CountData[7]), 
            new PieChart.Data ( WordsData[8], CountData[8] ),
            new PieChart.Data ( WordsData[9], CountData[9] ));       
            PieChart1.setVisible(true);
            PieChart1.setData(pieChartData);
            PieChart1.setLabelsVisible(true);
            
            
    
           
           // Store of Searched keyword
            historyWall.appendText("\n" + " You Search for : " + "\n");
            historyWall.appendText(keyword);
   //           XStream UsersXML = new XStream();
     //         String xml = UsersXML.toXML(GUIcontroller.UserIDS);  
            
        
            i = 0 ;  
            
            
            
        }
        catch(TwitterException ex){
             ex.printStackTrace();
             historyWall.appendText("Rate exceeded : restart app and try again later" + "\n");
             Map<String, RateLimitStatus> statusMap;
                try {
                    statusMap = twitter.getRateLimitStatus();
                 for (String str : statusMap.keySet()) {
              RateLimitStatus status = statusMap.get(str);
              historyWall.appendText("Limit type " + str + "\n" + "; Limit:" + status.getLimit() +  "\n" + " ; minutes  until reset: " + (status.getSecondsUntilReset()/60) + "\n"  );
              
          }
                } catch (TwitterException ex1) {
                    
                 historyWall.appendText("Error try to restart app");
                }
         
        }       catch (InterruptedException ex) {
                    Logger.getLogger(GUIcontroller.class.getName()).log(Level.SEVERE, null, ex);
                    
        
        
        
        
        }
        
        
        
        
        
         long endTime = ((System.currentTimeMillis() - startTime) / 1000) ; 
                if (endTime > 60 )
                {   endTime = endTime / 60 ;
                    String endingTime = String.valueOf(endTime);
                   System.out.println(endingTime);
                   historyWall.appendText(endingTime);
                    
               }
        
        
        
            }
    
          });
        
        
        
      SearchBtn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event1) {
                
            
     
           
            
         
        long startTime = System.currentTimeMillis() ;
       
//          
//                    
//          
                Query query = new Query ();      
      query.setResultType(Query.ResultType.mixed);
//        

       query.setCount(15);
       query.setLang(SearchLang);
       if (GeoDataSearch == 1)
       {
           Double LatDouble = Double.valueOf(LatText.getText());
            Double LogDouble = Double.valueOf(LogText.getText());
           QueryCount = 10 ; 
           numResults = 15 ;
             GeoLocation place1 = new GeoLocation (LatDouble, LogDouble);
             
        
         query.setGeoCode(place1 , Radius , Unit.valueOf("km"));
         historyWall.appendText(("Searching set for location  : " + place1 + ""
                 + "\n" ));
        }
//            
//
//        
            
         HashMap<Long, Boolean> tweetIDMap = new HashMap();
         HashMap<Long,Boolean> UserMap = new HashMap();
         HashMap<String, Long> NameMap = new HashMap();
         HashMap<Long, ArrayList<Long> > followerMap = new HashMap();
//               
//        
//         
          QueryResult result;
//        
       try{
               result = twitter.search(query);
              UserWall.clear();
               int i = 0 ;
               while (result.getCount() <= QueryCount  && tweetIDMap.size() <= numResults  ) {
                   
               
//                
//           
//                Get the results
                long minID = -1;
              
//            
            List<Status> tweets = result.getTweets();
//       
//            //Print out the results
             for (Status tweet : tweets) {
//               
//                     
//                    //Track min id so we can get the next 'page'
                    if(minID == -1 || tweet.getId() < minID)
                        minID = tweet.getId();
//
       
//                    tweetIDMap.put(tweet.getId(), Boolean.TRUE);
//                    
//                 
                        String userName = tweet.getUser().getName();
                        long userId = tweet.getUser().getId();
//                

//                    
                    UserMap.put(tweet.getUser().getId(),true);
                    NameMap.put(tweet.getUser().getName(), tweet.getUser().getId());
//                    
                    IDs ids = twitter.getFollowersIDs(userId, -1);
                    followerMap.put(userId, new ArrayList());
                    long[]  followerIdArray = ids.getIDs();
                   for (int y = 0 ; y <followerIdArray.length; ++y)
               {
                       long key = followerIdArray[y];
                        if(followerMap.containsKey(key))
                          {
                              followerMap.get(key).add(userId);
                          }
               }
//                            
                    UserWall.appendText("User : " + userId + " ( " +  userName + " ) " + " has " + followerIdArray.length + " followers "  );
             
             }  
          query.setMaxId(minID-1);
          result = twitter.search(query);
                         i = i + 1 ; 
           
            
                        if ( i % 15 == 0)
                        {   historyWall.appendText("sleeping....");
                       System.out.println("System is sleeping due limit");
                     
                      Thread.sleep(16 * 60 * 1000) ;
                      
                              }
             
          }  
       
      
        long endTime = ((System.currentTimeMillis() - startTime) / 1000) ; 
                if (endTime > 60 )
                {   endTime = endTime / 60 ;
                    String endingTime = String.valueOf(endTime);
                   System.out.println(endingTime);
                   UserWall.appendText(endingTime);
                    
               }
    
        
            }   catch (TwitterException ex) {
                    Logger.getLogger(GUIcontroller.class.getName()).log(Level.SEVERE, null, ex);
              
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUIcontroller.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }}); 
            
 
        
        
        
        
        
        
    
}
}

