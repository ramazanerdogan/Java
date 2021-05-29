
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class SinavHazirla {
 
        public static void main(String[] args) {
        
            Scanner scanner = new Scanner(System.in);
            do{
           
            System.out.println("Hangi türde sınav hazırlamak istiyorsunuz?"+
            "\n1-Test\n2-Klasik\n3-Karışık\n4-Çıkış");
           
           int sinavTuru = scanner.nextInt();
           
           if(sinavTuru == 4){
               break;
           }
 
           if(sinavTuru == 1){
              
               TestSinavi testSinavi1 = new TestSinavi();
               System.out.println("Hangi test işlemlerini yapmak istiyorsunuz?"+
                       "\n1-Soru ekle\n2-Soru çıkar\n3-Soru listele");
               
               int testSecim = scanner.nextInt();
               //SORU EKLE
               if(testSecim == 1){
                 
                    testSinavi1.soruEkle();
                   
                    for(int k = 0; k <= testSinavi1.kacinciSoruIndeks; k++){
                
                    testSinavi1.toplamPuan += testSinavi1.soruPuanDegeri.get(k);

                     }
               }
               //SORU ÇIKAR
               else if(testSecim == 2){
                   testSinavi1.soruCikar();
               }
               //SORU LİSTELE
               else if(testSecim == 3){
                   testSinavi1.soruListele();
               }
               
               else{
                   System.out.println("Hatalı işlem!");
               }
              
             try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sinavlar.dat",true))){
          
               oos.writeObject(testSinavi1);

      } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        }
               
           for(int i = 0; i <= testSinavi1.kacinciSoruIndeks; i++){
               if(testSinavi1.toplamPuan > 100 && testSinavi1.toplamPuan < 110){
                   System.out.println("Soruların toplam puan aralığı 100-110 arasındadır.Programdan çıkılıyor");
                   break;
               }
               
           }

           }
           //KLASİK
           else if(sinavTuru == 2){
               KlasikSinav klasikSinav1 = new KlasikSinav();
                System.out.println("Hangi klasik sınav işlemlerini yapmak istiyorsunuz?"+
                       "\n1-Soru ekle\n2-Soru çıkar\n3-Soru listele");
               
               int klasikSecim = scanner.nextInt();
               //SORU EKLE
               if(klasikSecim == 1){
                   klasikSinav1.soruEkle();
                   
               }
               //SORU ÇIKAR
               else if(klasikSecim == 2){
                   klasikSinav1.soruCikar();
                   
               }
               //SORU LİSTELE
               else if(klasikSecim == 3){
                   klasikSinav1.soruListele();
                   
               }
               
               else{
                   System.out.println("Hatalı işlem!");
               }
               
               try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sinavlar.dat",true))){
          
               oos.writeObject(klasikSinav1);
               
          
          
      } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        }
           }
           
           
           //KARIŞIK
           else if(sinavTuru == 3){
               
               KarisikSinav karisikSinav1 = new KarisikSinav();
               System.out.println("Hangi karışık sınav işlemlerini yapmak istiyorsunuz?"+
                       "\n1-Soru ekle\n2-Soru çıkar\n3-Soru listele");
               
               int karisikSecim = scanner.nextInt();
               
               if(karisikSecim == 1){
                   karisikSinav1.soruEkle();
                    
               }
               
               else if(karisikSecim == 2){
                   karisikSinav1.soruCikar();
                    
               }
               
               else if(karisikSecim == 3){
                   karisikSinav1.soruListele();
                    
               }
               
               else{
                   System.out.println("Hatalı işlem!");
               }
               
               try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sinavlar.dat",true))){
          
               oos.writeObject(karisikSinav1);
               
          
          
      } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        }
               
             }
           
            
        }while(true);
    }
        
}



