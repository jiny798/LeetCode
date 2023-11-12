import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    
    public int solution(String word, String[] pages) {
        Pattern homePattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
        Pattern urlPattern = Pattern.compile("<a href=\"https://(\\S*)\"");
        Pattern wordPattern = Pattern.compile("((?i)"+word+")[^a-zA-Z]");        
        Map<String,WebPage> map = new HashMap<>();
        
        Pattern wp = Pattern.compile("([^a-zA-Z])((?i)"+word+")([^a-zA-Z])");  
        String stt = "muzimuzi \n";
        Matcher w = wp.matcher(stt);
        if(w.find()){
            System.out.println("찾음");
        }
        
        int answer = 0;
        String homeUrl = "";
        for(int i = 0; i < pages.length; i++) {
            Matcher homeMatcher = homePattern.matcher(pages[i]);
            if(homeMatcher.find()){
                homeUrl = homeMatcher.group().split("=")[2].replaceAll("\"", ""); // https://a.com
            }
            
            Matcher urlMatcher = urlPattern.matcher(pages[i]);
            List<String> urlList = new ArrayList<>();
            while(urlMatcher.find()){
                urlList.add(urlMatcher.group().split("\"")[1]);
            }    
            Matcher wordMatcher = wordPattern.matcher(pages[i]);
            int wordCount = 0;
            while(wordMatcher.find()){
               wordCount++;
            }
            WebPage page = new WebPage();
            page.index = i;
            page.basicScore = wordCount;
            page.matchScore = wordCount;
            page.link = urlList.size();
            page.urlList = urlList;
            map.put(homeUrl,page);
        }
        
        ArrayList<WebPage> list = new ArrayList<>();
        for(Map.Entry<String,WebPage> entry : map.entrySet()){
            WebPage page = entry.getValue(); // www.b.com
            double linkScore = (double)page.basicScore / page.link ;
            List<String> urlList = page.urlList;
            for(String extUrl : urlList){ // a , c 
                if( map.get(extUrl) != null){
                    WebPage findPage = map.get(extUrl);
                    findPage.matchScore += linkScore;
                }
            }           
            list.add(page);
        }
        
        // Collections.sort(list, (web1,web2) -> {
        //     if(web1.matchScore < web2.matchScore){
        //         return 1;
        //     }else if(web1.matchScore == web2.matchScore){
        //         return web1.index - web2.index;
        //     }
        //     return 0;
        // });
        double max = 0;
        int maxIndex = 0;
        for(int i = 0 ; i < list.size() ; i++){
            if(max < list.get(i).matchScore){
                max = list.get(i).matchScore;
                maxIndex = list.get(i).index;
            }else if(max == list.get(i).matchScore){
                if(maxIndex > list.get(i).index){
                    maxIndex = list.get(i).index;
                }
            }
        }
        
        for(WebPage p : list){
            System.out.println(p.index+" "+p.matchScore);
        }
        
        return maxIndex;
    }
    
    class WebPage {
        public int index;
        public int basicScore;
        public int link;
        public double linkScore;
        public double matchScore;
        public List<String> urlList;
    }
}