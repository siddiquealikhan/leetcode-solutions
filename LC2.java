// LC2 - VALID ANAGRAMS
public class LC2 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int count[] = new int[26];

        for(int i = 0; i<s.length(); i++){
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            count[a]++;
            count[b]--;
        }
        for(int j = 0; j<count.length; j++){
            if(count[j]!=0){
                return false;
            }
        }

        return true;
    }
}
