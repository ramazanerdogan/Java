import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KarisikSinav extends SoruBankasi{

    Scanner scanner = new Scanner(System.in);
    TestSinavi testSinavi1 = new TestSinavi();
    KlasikSinav klasikSinav1 = new KlasikSinav();
    //SORULAR
    ArrayList<String> dogruyanlisSorusu = new ArrayList<String>();
    ArrayList<String> boslukdoldurmaSorusu = new ArrayList<String>();
    //CEVAPLAR
    ArrayList<String> dogruyanlisCevap = new ArrayList<String>();
    ArrayList<String> boslukdoldurmaCevap = new ArrayList<String>();
    //İNDEKSLER
    int boslukDoldurmaIndeks = -1;
    int dogruyanlisIndeks = -1;
    
    
    
    @Override
    void soruEkle() {
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sorubankasi.dat",true))){
            //TEST SINAVI
            System.out.println("Lütfen test sınavı için soru giriniz:");
            testSinavi1.soruEkle();
            
            System.out.println("*******************************");
            System.out.println("Test sınavı işlemleri bitti sırada klasik soru işlemleri var");
            System.out.println("*******************************");
            
            //KLASİK SINAV
            System.out.println("Lütfen klasik sınav için soru giriniz:");
            klasikSinav1.soruEkle();
            
            System.out.println("*******************************");
            System.out.println("Klasik sınav işlemleri bitti sırada boşluk doldurmalı soru işlemleri var");
            System.out.println("*******************************");
            
            //BOŞLUK DOLDURMA 
            boslukDoldurmaIndeks++;
            System.out.println("Lütfen boşluk doldurmalı soru tipine uygun " +(boslukDoldurmaIndeks+1)+".soruyu giriniz:");
            boslukdoldurmaSorusu.add(scanner.nextLine());
            System.out.println("Sorunuzun doğru cevabını giriniz");
            boslukdoldurmaCevap.add(scanner.nextLine());
            
            
            //DOĞRU YANLIŞ
            dogruyanlisIndeks++;
            System.out.println("Lütfen Doğru-Yanlış tipine uygun" + (dogruyanlisIndeks+1) + ".soruyu giriniz:");
            dogruyanlisSorusu.add(scanner.nextLine());
            System.out.println("Lütfen sorunuzun cevabını D veya Y şeklinde belirtiniz:");
            dogruyanlisCevap.add(scanner.nextLine());
                    
           // oos.writeObject(testSinavi1);
           // oos.writeObject(klasikSinav1);
            oos.writeObject(boslukdoldurmaSorusu);
            oos.writeObject(dogruyanlisSorusu);
            //oos.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        }
        
       
        
    }

    @Override
    void soruCikar() {
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
            
            KarisikSinav karisikSinav1 = new KarisikSinav();
            System.out.println("" + (String)ois.readObject());
            
            System.out.println("Hangi sınav için soru silme işlemi yapacaksınız");
            System.out.println("1-Test\n2-Klasik\n3-Boşluk doldurma\n4-Doğru-Yanlış");
            int secim = scanner.nextInt();
            
            if(secim == 1){
                while(true){
                 System.out.println("Soru ekleme işleminden çıkmak istiyorsanız 4, çıkmak istemiyorsanız 5 giriniz");
               int ekle = scanner.nextInt();
               scanner.nextLine();
               if(ekle == 4){
                   break;
               }
                 
                 System.out.println("Aramak istediğiniz kelimeyi girin");
                 String araKelime = scanner.nextLine();
              
                 for(int a = 0; a <= testSinavi1.kacinciSoruIndeks; a++){
                    if(testSinavi1.testSoru.contains(araKelime)){
                         System.out.println("-Kelimenizin geçtiği sorular-");
                         System.out.println(testSinavi1.testSoru.get(a));
                         
                           System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                           int soruNumarasi = scanner.nextInt();
                           
                           testSinavi1.testSoru.remove(soruNumarasi - 1);
                           System.out.println(testSinavi1.testSoru.get(soruNumarasi - 1) + " sorusu başarı ile silindi.");
                    }
                }
                }
            }
            
            else if(secim == 2){
                
                 System.out.println("Aramak istediğiniz kelimeyi girin");
                 String araKelime = scanner.nextLine();
              
                 for(int a = 0; a <= klasikSinav1.soruIndeks; a++){
                    if(klasikSinav1.klasikSoru.contains(araKelime)){
                         System.out.println("-Kelimenizin geçtiği sorular-");
                         System.out.println(klasikSinav1.klasikSoru.get(a));
                         
                           System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                           int soruNumarasi = scanner.nextInt();
                           
                           klasikSinav1.klasikSoru.remove(soruNumarasi - 1);
                           System.out.println(klasikSinav1.klasikSoru.get(soruNumarasi - 1) + " sorusu başarı ile silindi.");
                
                
            }
                 }
            
            }
            
            else if(secim == 3){
                
                 System.out.println("Aramak istediğiniz kelimeyi girin");
                 String araKelime = scanner.nextLine();
                 
                 for(int a = 0; a <= boslukDoldurmaIndeks; a++){
                      if(boslukdoldurmaSorusu.contains(araKelime)){
                          System.out.println("-Kelimenizin geçtiği sorular-");
                          System.out.println(boslukdoldurmaSorusu.get(a));
                          
                          System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                          int soruNumarasi = scanner.nextInt();
                          
                          boslukdoldurmaSorusu.remove(boslukDoldurmaIndeks - 1);
                          System.out.println(boslukdoldurmaSorusu.get(soruNumarasi - 1) + " sorusu başarı ile silindi");
                 }
                 
                 }
                
            }
            
            else if(secim == 4){
              
                System.out.println("Aramak istediğiniz kelimeyi girin");
                String araKelime = scanner.nextLine();
                 
                for(int a = 0; a <= dogruyanlisIndeks; a++){
                    if(dogruyanlisSorusu.contains(araKelime)){
                        System.out.println("-Kelimenizin geçtiği sorular");
                        System.out.println(dogruyanlisSorusu.get(a));
                        
                        System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                        int soruNumarasi = scanner.nextInt();
                        
                        dogruyanlisSorusu.remove(dogruyanlisIndeks - 1);
                        System.out.println(dogruyanlisSorusu.get(soruNumarasi - 1) + " sorusu başarı ile silindi.");
                    
                    }
                
                }
                
            }
            
            else{
                System.out.println("Hatalı işlem!");
            }
            
            
        
         
         
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found exception!(Try-Catch)dene");
        }
        
    }

        

    

    @Override
    void soruListele() {
        
         System.out.println("Hangi sınav türünün sorularını listelemek istiyorsunuz?");
         System.out.println("1-Test\n2-Klasik\n3-Boşluk Doldurma\n4-Doğru-Yanlış");
            
         int listeSecim = scanner.nextInt();
            
         if(listeSecim == 1){
             testSinavi1.soruListele();
         }   
         
         else if(listeSecim == 2){
             klasikSinav1.soruListele();
         }
         
         else if(listeSecim == 3){
             try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
            
                System.out.println("" + (String)ois.readObject());
             
             System.out.println("Boşluk doldurma soru tipi için aramak istediğiniz kelimeyi giriniz:");
             String boslukdoldurmaKelimeAra = scanner.nextLine();
             
             for(int a = 0; a <= boslukDoldurmaIndeks; a++){
                 if(boslukdoldurmaKelimeAra.contains(boslukdoldurmaSorusu.get(a))){
                     System.out.println("-İçerisinde girdiğiniz anahtar kelime bulunan sorular-");
                     System.out.println(boslukdoldurmaSorusu.get(a));
                 }
                 else{
                     System.out.println("Aradığınız kelimeyle eşleşen soru bulunamadı");
                 }
             }
             
             
             } catch (FileNotFoundException ex) {
                 System.out.println("File not found exception!");
             } catch (IOException ex) {
                 System.out.println("IO exception!");
             } catch (ClassNotFoundException ex) {
                System.out.println("Class not found exception!");
             }

         }
         
         
         else if(listeSecim == 4){
             try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
              System.out.println("" + (String)ois.readObject());
                 
            System.out.println("Doğru-Yanlış soru tipi için aramak istediğiniz kelimeyi giriniz:");
            String dogruYanlisKelimeAra = scanner.nextLine();
            
            for(int a = 0; a <= dogruyanlisIndeks; a++){
                if(dogruYanlisKelimeAra.contains(dogruyanlisSorusu.get(a))){
                    System.out.println("-İçerisinde girdiğiniz anahtar kelime bulunan sorular-");
                    System.out.println(dogruyanlisSorusu.get(a));
                }
                else{
                    System.out.println("Aradığınız kelimeyle eşleşen soru bulunamadı");
                }
                
            }
             } catch (FileNotFoundException ex) {
                System.out.println("File not found exception!");
             } catch (IOException ex) {
                 System.out.println("IO exception!");
             } catch (ClassNotFoundException ex) {
                 System.out.println("Class not found exception!");
             }
            
         }
         
         else{
             System.out.println("Hatalı seçim!");
         }
    }
    
}
