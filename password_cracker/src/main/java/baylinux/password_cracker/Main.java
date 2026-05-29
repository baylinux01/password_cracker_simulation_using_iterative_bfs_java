package baylinux.password_cracker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        String password="1258";
        crackPassword(48,57,3,4,password);   
    }
    
    public static void crackPassword(int asciiStart, int asciiEnd, int minDigits, int maxDigits,String password) 
    {
    	
        List<String> alphabet = new ArrayList<String>();
        
        for (int i = asciiStart; i <= asciiEnd; i += 1) 
        {
            alphabet.add(String.valueOf((char) i));
        }

        Queue<String> queue = new LinkedList<String>();

        for (String letter : alphabet) 
        {
            queue.add(letter);
        }
        int attempt=0;
        while (!queue.isEmpty()) 
        {
            String currentWord = queue.poll();
            if (currentWord.length() >= minDigits) 
            {
            	if(currentWord.equals(password))
            	{
            		attempt+=1;
            		System.out.println("Password cracked in attempt: "+attempt+" and found as: "+currentWord);
            		return;
            	}
            	else
            	{
            		attempt+=1;
            		System.out.println("Attempt: "+attempt+" and the word tried is: "+currentWord);
            		
            	}
                
            }
            if (currentWord.length() < maxDigits) 
            {
                for (String letter : alphabet) 
                {
                    String newWord = currentWord + letter;
                    queue.add(newWord);
                }
            }
        }

     
      
    }
    
    public static void findCombinationsIterativelyWithBFS(int asciiStart, int asciiEnd, int minDigits, int maxDigits) 
    {
    	
        List<String> results = new ArrayList<String>();
        
        List<String> alphabet = new ArrayList<String>();
        
        for (int i = asciiStart; i <= asciiEnd; i += 1) 
        {
            alphabet.add(String.valueOf((char) i));
        }

        Queue<String> queue = new LinkedList<String>();

        for (String letter : alphabet) 
        {
            queue.add(letter);
        }
        
        while (!queue.isEmpty()) 
        {
            String currentWord = queue.poll();
            if (currentWord.length() >= minDigits) 
            {
                results.add(currentWord);
            }
            if (currentWord.length() < maxDigits) 
            {
                for (String letter : alphabet) 
                {
                    String newWord = currentWord + letter;
                    queue.add(newWord);
                }
            }
        }

     
        System.out.println("Toplam " + results.size() + " kombinasyon bulundu (Iteratif).");
        
        for(int i=0; i<Math.min(20, results.size()); i+=1) 
        {
            System.out.println(results.get(i));
        }
    }
    public static void findCombinationsIterativelyWithDFS(int asciiStart, int asciiEnd, int minDigits, int maxDigits) 
    {
        List<String> results = new ArrayList<String>();
        
        List<String> alphabet = new ArrayList<String>();
        for (int i = asciiStart; i <= asciiEnd; i += 1) 
        {
            alphabet.add(String.valueOf((char) i));
        }

        LinkedList<String> stack = new LinkedList<String>();

        for (int i = alphabet.size() - 1; i >= 0; i-=1) 
        {
            stack.push(alphabet.get(i)); 
        }

        
        while (!stack.isEmpty()) 
        {
            
            String currentWord = stack.pop();
            
            
            if (currentWord.length() >= minDigits) 
            {
                results.add(currentWord);
            }

            if (currentWord.length() < maxDigits) 
            {
                for (int i = alphabet.size() - 1; i >= 0; i-=1) 
                {
                    String newWord = currentWord + alphabet.get(i);
                    stack.push(newWord);
                }
            }
        }

       
        System.out.println("Toplam " + results.size() + " kombinasyon bulundu (Iteratif DFS).");
        for(String s : results) 
        {
            System.out.println(s);
        }
    }
    public static void findCombinationsRecursivelyWithDFS(List<String> current,List<String> results,int asciiStart, int asciiEnd,int minDigits, int maxDigits)
    {
    	List<String> alphabet=new ArrayList<String>();
    	for(int i=asciiStart;i<=asciiEnd;i+=1)
    	{
    		alphabet.add(String.valueOf((char)i));
    	}
    	for(String letter : alphabet)
    	{
    		current.add(letter);
    		String wordComposed=convertListToString(current);
    		results.add(wordComposed);
    		
    		if(current.size()<maxDigits)
    		{
    			findCombinationsRecursivelyWithDFS(current,results,asciiStart,asciiEnd,minDigits,maxDigits);
    		}
    		
    		current.remove(current.size()-1);
    	}
    	
    }
    
    
    public static String convertListToString(List<String> list)
    {
    	StringBuffer sb=new StringBuffer();
    	for(String s: list)
    	{
    		sb.append(s);
    	}
    	return String.valueOf(sb);
    }
}
