package algoritmaVizeOdev;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Test {
	static double parcalaMax(double dizi[], int kucuk�ndex, int buyuk�ndex) //2.y�ntem i�in maximum de�er i�in foksiyon tan�ml�yoruz
	{
		double max; //1
	    if (kucuk�ndex >= buyuk�ndex - 2) //en k���k ve en b�y�k de�er ile kar��la�t�rma yap�l�yor.
	    { 
	        if (dizi[kucuk�ndex] > dizi[kucuk�ndex + 1]) 
	            return dizi[kucuk�ndex]; //1
	        else
	            return dizi[kucuk�ndex + 1]; //1
	    } 
	    max = parcalaMax(dizi, kucuk�ndex + 1, buyuk�ndex); //�zyinelemeli olarak de�er bulunana kadar devam eder. 
	    if (dizi[kucuk�ndex] > max) //dizi de�eri ile yeni gelen de�i�kenin kar��la�t�rmas� yap�l�r.
	        return dizi[kucuk�ndex];//1 
	    else
	        return max; //�zyinelemeli olarak �a��r�lan de�er �artlar� sa�l�yorsa cevap olarak d�nd�r�l�r
	} 
	static double parcalaMin(double dizi[], int kucuk�ndex, int buyuk�ndex)//2.y�ntem i�in maximum de�er i�in foksiyon tan�ml�yoruz
	{
		double min; 
	    if (kucuk�ndex >= buyuk�ndex - 2) { 
	        if (dizi[kucuk�ndex] < dizi[kucuk�ndex + 1]) 
	            return dizi[kucuk�ndex]; //1
	        else
	            return dizi[kucuk�ndex + 1]; //1
	    } 
	    min = parcalaMin(dizi, kucuk�ndex + 1, buyuk�ndex); //�zyinelemeli olarak de�er bulunana kadar devam eder.
	    if (dizi[kucuk�ndex] < min) //dizi de�eri ile yeni gelen de�i�kenin kar��la�t�rmas� yap�l�r.
	        return dizi[kucuk�ndex]; //
	    else
	        return min; //�zyinelemeli olarak �a��r�lan de�er �artlar� sa�l�yorsa cevap olarak d�nd�r�l�r
	} 	
		static double[] dolar = new double[116];// kur de�eri i�in dizi tan�ml�yoruz.//8n
		static String[] tarihvekur = new String[116];// tarih ve kur de�erini beraber tuttu�umuz dizi tan�m� yap�yoruz.
	public static void main(String[] args) {    
		double minSayi, maxSayi;// 2.y�ntem i�in k���k ve b�y�k de�er i�in tan�mlama yap�yoruz�
        try(Scanner scanner = new Scanner(new FileReader("dolarkuru.txt")))//verilen text dosyas�ndan veri �ekmek i�in dosya ismini yaz�yoruz.
        {               
          String[] a; //text dosyas�ndaki b�l�mleri almak i�in dizi de�erini kullan�yoruz.
          String[] tarih = new String[116]; //tarih i�in dizi tan�mlamas� yap�yoruz.        
          double[] tempArray = new double[116]; //ge�ici de�erlerin tutulmas� i�in dizi tan�ml�yoruz.        
                for(int i = 0; scanner.hasNextLine(); i++)//degerleri okumak i�in for tan�mluyoruz.
                {
                	tarihvekur[i] = scanner.nextLine();   
                    a = tarihvekur[i].split("\t");
                    tarih[i] = a[0];//textin ilk k�sm�nda yarih yazd��� i�in buradaki verileri diziye al�yoruz.
                    dolar[i] = Double.valueOf(a[1]);//texten kur de�erlerini doubleye �evirerek diziye yaz�yoruz.
                }                           
                System.out.println("1.y�ntem");
                System.out.println("--------------------------------------------------------------------------------");
                double max=dolar[0];//kar��la�t�rma yapmak i�in ilk de�er atamas� yap�l�yor.
                double min=dolar[0];////kar��la�t�rma yapmak i�in ilk de�er atamas� yap�l�yor.
                int maxSayac=0,minSayac=0;
//**********************************1.y�ntem*******************************************************               
                for (int i = 0; i < dolar.length; i++)//bu b�l�mden en k���k ve en b�y�k dizi de�erlerini bulmak i�in t�m dizi elemanlar� tek tek kar��la�t�r�larak maximum ve minimum de�eler bulunuyor.
                {     
                	if (dolar[i] > max)//en b�y�k de�er i�in kar��la�t�rma yap�l�yor. 
                	{
                        max = dolar[i]; 
                        maxSayac=i;
                    }
                    if(dolar[i]<min) //en k���k de�er i�in kar��la�t�rma yap�l�yor.
                    {
                        min=dolar[i]; 
                        minSayac=i;
                    }
                }
                if(maxSayac>minSayac) {//tarih ve kur de�erlerinde ixdex de�erleri ayn� oldu�u i�in en b�y�k de�erler bulunurken sayac ile index de�erleri al�n�yor ve daha sonra kar��la�t�r�l�yor.
                	 System.out.println("al�nan tarih sat�lan tarihten �nce oldu�u i�in i�lem ba�ar�l�");
                	 System.out.println("en d���k al�nacak de�er   " + tarihvekur[minSayac]);
                     System.out.println("en y�ksek sat�lacak de�er " + tarihvekur[maxSayac]);                
                     double kar1=dolar[maxSayac]-dolar[minSayac];
                     System.out.println("1 dolarda edilecek kar: "+kar1);
                }
                else //aksi durumda hata mesaj� verliyor.
                	System.out.println("al�nan tarih sat�lan tarihten sonra oldu�u i�in i�lem ba�ar�s�z.");          
//********************************2.y�ntem*********************************************************
                maxSayi=parcalaMax(dolar, 0, dolar.length); //max fonksiyonuna de�erler g�nderilerek maximum de�er al�n�yor.
                minSayi=parcalaMin(dolar,0,dolar.length);//mix fonksiyonuna de�erler g�nderilerek maximum de�er al�n�yor.
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("2.Y�ntem ");
                al(minSayi,maxSayi);//bulunan maximum ve minimum de�erler fonksiyona g�ndererek tarih ve di�er i�lemler yapt�r�larak ekrana yaz�lmas� sa�lan�yor.
                
////********************************3.y�ntem*********************************************************
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("3.Y�ntem ");
                for(int i = 0; i <dolar.length; i++)//kur de�erleri for yard�m� ile tempArray dizisine koyalanarak burda s�ralama i�lemi ger�ekle�tirmek i�in kullan�lacak
                {
                tempArray[i] = dolar[i];
                }                
                Arrays.sort(tempArray, 0, dolar.length);//kur dizisi de�erleri temp dizisine sort ediliyor.
                double minDeger = tempArray[0];
                double maxDeger = 0.0;
                for(int i = 0; i < dolar.length; i++)//tempArray dizisindeki t�m de�erler s�ral� hale getirilip atan�yor s�ras�yla.
                {
                if(tempArray[i] > maxDeger)//maximum de�er bulunarak atama yap�l�yor.
                    maxDeger = tempArray[i];                        
                if(tempArray[i] < minDeger)//minimum de�er bulunarak atama yap�l�yor.
                    minDeger = tempArray[i];                                 
                }  
                al(minDeger,maxDeger);     //bulunan maximum ve minimum de�erler fonksiyona g�ndererek tarih ve di�er i�lemler yapt�r�larak ekrana yaz�lmas� sa�lan�yor.  
              
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);}//olas� hata ��kmas� durumunda ekrana yaz�lacak hata
    }
	public static void al (double minimumDeger,double maximumDeger) //en b�y�k ve en k���k de�erler fonksiyona atan�yor
	{
		int minimum�ndex=0 ,maximum�ndex=0;
		for(int e=0;e<dolar.length;e++) //burada tarih ve kur de�erleri indexleri ayn� oldu�u i�in en b�y�k ve en k���k de�erin index de�erini buluyoruz.
        {              	
      	if(dolar[e]==maximumDeger)     //bulunan de�erin indexi kullanmak i�in de�i�kene at�yoruz.          		
      		maximum�ndex=e;            	
      	if(dolar[e]==minimumDeger)	   //bulunan de�erin indexi kullanmak i�in de�i�kene at�yoruz.      		
      		minimum�ndex=e;            	             	
        }
        if(maximum�ndex>minimum�ndex)//index de�erlerinin kar��la�t�rmas�n� yap�yoruz ��nk� al�m sat�mdan �nce olmad��� i�in b�yle bir kar��la�t�rma y�ntemine gidiyoruz.
      		{
        	 System.out.println("al�nan tarih sat�lan tarihten �nce oldu�u i�in i�lem ba�ar�l�");
      		 System.out.println("en d���k al�nacak de�er:    "+tarihvekur[minimum�ndex]);// maximum de�er i�in tarih ve kur de�erlerini yazd�r�yoruz.
             System.out.println("en y�ksek sat�lacak de�er:  "+tarihvekur[maximum�ndex]);   //maximum de�er i�in tarih ve kur de�erlerini yazd�r�yoruz.                   
             double kar3=maximumDeger-minimumDeger; //bulunan de�erlerden ��karma i�lemi yaparak bir dolardaki kar de�erini buluyoruz.
             System.out.println("1 dolarda edilecek kar: "+kar3);//kar de�erini ekrana yazd�r�yoruz.     		
      		}
        else //aksi durumda programa hata verdiriyoruz.
        	System.out.println("al�nan tarih sat�lan tarihten sonra oldu�u i�in i�lem ba�ar�s�z.");        
	}
}
