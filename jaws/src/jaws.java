public class jaws {
    public static void main(String[] args) {
        System.out.println(rRule("rearview"));
    }
        public static String rRule(String s){
            s = s.toLowerCase();
            while(s.contains("ar")){
                s.replaceAll("ar", "ah");
                int i = s.indexOf("ar");
                s = s.substring(0,i) + "h" + s.substring(i + 1);
            }

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'r'){
                    char c = s.charAt(i-1);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        s = s.substring(0,i) + 'h' + s.substring(i+1);
                    }
                }
            }

            return s;
        }
}
