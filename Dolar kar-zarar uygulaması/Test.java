package algoritmaVizeOdev;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Test {
	static double parcalaMax(double dizi[], int kucukÝndex, int buyukÝndex) //2.yöntem için maximum deðer için foksiyon tanýmlýyoruz
	{
		double max; //1
	    if (kucukÝndex >= buyukÝndex - 2) //en küçük ve en büyük deðer ile karþýlaþtýrma yapýlýyor.
	    { 
	        if (dizi[kucukÝndex] > dizi[kucukÝndex + 1]) 
	            return dizi[kucukÝndex]; //1
	        else
	            return dizi[kucukÝndex + 1]; //1
	    } 
	    max = parcalaMax(dizi, kucukÝndex + 1, buyukÝndex); //özyinelemeli olarak deðer bulunana kadar devam eder. 
	    if (dizi[kucukÝndex] > max) //dizi deðeri ile yeni gelen deðiþkenin karþýlaþtýrmasý yapýlýr.
	        return dizi[kucukÝndex];//1 
	    else
	        return max; //özyinelemeli olarak çaðýrýlan deðer þartlarý saðlýyorsa cevap olarak döndürülür
	} 
	static double parcalaMin(double dizi[], int kucukÝndex, int buyukÝndex)//2.yöntem için maximum deðer için foksiyon tanýmlýyoruz
	{
		double min; 
	    if (kucukÝndex >= buyukÝndex - 2) { 
	        if (dizi[kucukÝndex] < dizi[kucukÝndex + 1]) 
	            return dizi[kucukÝndex]; //1
	        else
	            return dizi[kucukÝndex + 1]; //1
	    } 
	    min = parcalaMin(dizi, kucukÝndex + 1, buyukÝndex); //özyinelemeli olarak deðer bulunana kadar devam eder.
	    if (dizi[kucukÝndex] < min) //dizi deðeri ile yeni gelen deðiþkenin karþýlaþtýrmasý yapýlýr.
	        return dizi[kucukÝndex]; //
	    else
	        return min; //özyinelemeli olarak çaðýrýlan deðer þartlarý saðlýyorsa cevap olarak döndürülür
	} 	
		static double[] dolar = new double[116];// kur deðeri için dizi tanýmlýyoruz.//8n
		static String[] tarihvekur = new String[116];// tarih ve kur deðerini beraber tuttuðumuz dizi tanýmý yapýyoruz.
	public static void main(String[] args) {    
		double minSayi, maxSayi;// 2.yöntem için küçük ve büyük deðer için tanýmlama yapýyoruzç
        try(Scanner scanner = new Scanner(new FileReader("dolarkuru.txt")))//verilen text dosyasýndan veri çekmek için dosya ismini yazýyoruz.
        {               
          String[] a; //text dosyasýndaki bölümleri almak için dizi deðerini kullanýyoruz.
          String[] tarih = new String[116]; //tarih için dizi tanýmlamasý yapýyoruz.        
          double[] tempArray = new double[116]; //geçici deðerlerin tutulmasý için dizi tanýmlýyoruz.        
                for(int i = 0; scanner.hasNextLine(); i++)//degerleri okumak için for tanýmluyoruz.
                {
                	tarihvekur[i] = scanner.nextLine();   
                    a = tarihvekur[i].split("\t");
                    tarih[i] = a[0];//textin ilk kýsmýnda yarih yazdýðý için buradaki verileri diziye alýyoruz.
                    dolar[i] = Double.valueOf(a[1]);//texten kur deðerlerini doubleye çevirerek diziye yazýyoruz.
                }                           
                System.out.println("1.yöntem");
                System.out.println("--------------------------------------------------------------------------------");
                double max=dolar[0];//karþýlaþtýrma yapmak için ilk deðer atamasý yapýlýyor.
                double min=dolar[0];////karþýlaþtýrma yapmak için ilk deðer atamasý yapýlýyor.
                int maxSayac=0,minSayac=0;
//**********************************1.yöntem*******************************************************               
                for (int i = 0; i < dolar.length; i++)//bu bölümden en küçük ve en büyük dizi deðerlerini bulmak için tüm dizi elemanlarý tek tek karþýlaþtýrýlarak maximum ve minimum deðeler bulunuyor.
                {     
                	if (dolar[i] > max)//en büyük deðer için karþýlaþtýrma yapýlýyor. 
                	{
                        max = dolar[i]; 
                        maxSayac=i;
                    }
                    if(dolar[i]<min) //en küçük deðer için karþýlaþtýrma yapýlýyor.
                    {
                        min=dolar[i]; 
                        minSayac=i;
                    }
                }
                if(maxSayac>minSayac) {//tarih ve kur deðerlerinde ixdex deðerleri ayný olduðu için en büyük deðerler bulunurken sayac ile index deðerleri alýnýyor ve daha sonra karþýlaþtýrýlýyor.
                	 System.out.println("alýnan tarih satýlan tarihten önce olduðu için iþlem baþarýlý");
                	 System.out.println("en düþük alýnacak deðer   " + tarihvekur[minSayac]);
                     System.out.println("en yüksek satýlacak deðer " + tarihvekur[maxSayac]);                
                     double kar1=dolar[maxSayac]-dolar[minSayac];
                     System.out.println("1 dolarda edilecek kar: "+kar1);
                }
                else //aksi durumda hata mesajý verliyor.
                	System.out.println("alýnan tarih satýlan tarihten sonra olduðu için iþlem baþarýsýz.");          
//********************************2.yöntem*********************************************************
                maxSayi=parcalaMax(dolar, 0, dolar.length); //max fonksiyonuna deðerler gönderilerek maximum deðer alýnýyor.
                minSayi=parcalaMin(dolar,0,dolar.length);//mix fonksiyonuna deðerler gönderilerek maximum deðer alýnýyor.
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("2.Yöntem ");
                al(minSayi,maxSayi);//bulunan maximum ve minimum deðerler fonksiyona göndererek tarih ve diðer iþlemler yaptýrýlarak ekrana yazýlmasý saðlanýyor.
                
////********************************3.yöntem*********************************************************
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("3.Yöntem ");
                for(int i = 0; i <dolar.length; i++)//kur deðerleri for yardýmý ile tempArray dizisine koyalanarak burda sýralama iþlemi gerçekleþtirmek için kullanýlacak
                {
                tempArray[i] = dolar[i];
                }                
                Arrays.sort(tempArray, 0, dolar.length);//kur dizisi deðerleri temp dizisine sort ediliyor.
                double minDeger = tempArray[0];
                double maxDeger = 0.0;
                for(int i = 0; i < dolar.length; i++)//tempArray dizisindeki tüm deðerler sýralý hale getirilip atanýyor sýrasýyla.
                {
                if(tempArray[i] > maxDeger)//maximum deðer bulunarak atama yapýlýyor.
                    maxDeger = tempArray[i];                        
                if(tempArray[i] < minDeger)//minimum deðer bulunarak atama yapýlýyor.
                    minDeger = tempArray[i];                                 
                }  
                al(minDeger,maxDeger);     //bulunan maximum ve minimum deðerler fonksiyona göndererek tarih ve diðer iþlemler yaptýrýlarak ekrana yazýlmasý saðlanýyor.  
              
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);}//olasý hata çýkmasý durumunda ekrana yazýlacak hata
    }
	public static void al (double minimumDeger,double maximumDeger) //en büyük ve en küçük deðerler fonksiyona atanýyor
	{
		int minimumÝndex=0 ,maximumÝndex=0;
		for(int e=0;e<dolar.length;e++) //burada tarih ve kur deðerleri indexleri ayný olduðu için en büyük ve en küçük deðerin index deðerini buluyoruz.
        {              	
      	if(dolar[e]==maximumDeger)     //bulunan deðerin indexi kullanmak için deðiþkene atýyoruz.          		
      		maximumÝndex=e;            	
      	if(dolar[e]==minimumDeger)	   //bulunan deðerin indexi kullanmak için deðiþkene atýyoruz.      		
      		minimumÝndex=e;            	             	
        }
        if(maximumÝndex>minimumÝndex)//index deðerlerinin karþýlaþtýrmasýný yapýyoruz çünkü alým satýmdan önce olmadýðý için böyle bir karþýlaþtýrma yöntemine gidiyoruz.
      		{
        	 System.out.println("alýnan tarih satýlan tarihten önce olduðu için iþlem baþarýlý");
      		 System.out.println("en düþük alýnacak deðer:    "+tarihvekur[minimumÝndex]);// maximum deðer için tarih ve kur deðerlerini yazdýrýyoruz.
             System.out.println("en yüksek satýlacak deðer:  "+tarihvekur[maximumÝndex]);   //maximum deðer için tarih ve kur deðerlerini yazdýrýyoruz.                   
             double kar3=maximumDeger-minimumDeger; //bulunan deðerlerden çýkarma iþlemi yaparak bir dolardaki kar deðerini buluyoruz.
             System.out.println("1 dolarda edilecek kar: "+kar3);//kar deðerini ekrana yazdýrýyoruz.     		
      		}
        else //aksi durumda programa hata verdiriyoruz.
        	System.out.println("alýnan tarih satýlan tarihten sonra olduðu için iþlem baþarýsýz.");        
	}
}
