import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main
{
    // somme[i][j] est la table dynamique qui stocke les boolean
    static boolean[][] somme;
      
    static void display(ArrayList<Integer> v)
    {
       System.out.println(v);
    }
      
    
    //vecteur v stock les substes
    static void printSubsetsRec(int e[], int n, int s,
                                         ArrayList<Integer> p)
    {
        // si le tableau e est vide est s>0 c'st impossible de trouver un subset
        
        if (n == 0 && s != 0 && somme[0][s])
        {
            p.add(e[n]);
            display(p);
            p.clear();
            return;
        }
      
        // toujours true
        if (n == 0 && s == 0)
        {
            display(p);
            p.clear();
            return;
        }
      
      
        if (somme[n-1][s])
        {
            // nouveau vecteur pour stocker le chemin
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(e, n-1, s, b);
        }
      
        
        if (s >= e[n] && somme[n-1][s-e[n]])
        {
            p.add(e[n]);
            printSubsetsRec(e, n-1, s-e[n], p);
        }
    }
      
    
    static void subsets(int e[], int n, int s)
    {
        if (n == 0 || s < 0)
           return;
      
 
        somme = new boolean[n][s + 1];
        for (int i=0; i<n; ++i)
        {
            somme[i][0] = true; 
        }
      
       
        if (e[0] <= s)
           somme[0][e[0]] = true;
      
        
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < s + 1; ++j)
                somme[i][j] = (e[i] <= j) ? (somme[i-1][j] ||
                                           somme[i-1][j-e[i]])
                                         : somme[i - 1][j];
        if (somme[n-1][s] == false)
        {
            System.out.println("ya pas de subset");
            return;
        }
      
        
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(e, n-1, s, p);
    }
  static void tabAuto(int[] t, int max) 
{
 final Random random = new Random();
 for (int i = 0; i < t.length; i++)
 t[i] = random.nextInt(max);
  }

static void manual(int[] t, int max) 
{
	
Scanner input = new Scanner(System.in);
System.out.println("Remplissage du Tableau :");
for (int i=0;i<t.length;i++) {

	t[i] = input.nextInt();}
}

  static void afficher(int[] t)
{
System.out.print("\t[");
for (int i = 0; i < t.length; i++)
System.out.print(" " + t[i]);
System.out.println(" ]");
}
    
    public static void main(String args[])
      {Scanner input = new Scanner(System.in);
        System.out.print("number of elements : ");
        int n = input.nextInt();
        System.out.print("\t  1/manually // 2/automatically generated:    ");
        int k = input.nextInt();
        int[] e=new int[n];
        if (k!=1) tabAuto(e, n);
        else  manual(e, n);
        afficher(e);
        System.out.print("s: ");
        int s = input.nextInt();
        
        subsets(e, n, s);
    }
}
