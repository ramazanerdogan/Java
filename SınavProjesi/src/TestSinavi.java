
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSinavi extends SoruBankasi{

        ArrayList<String> testSoru = new ArrayList<String>();
        ArrayList<String> aSikki = new ArrayList<String>();
        ArrayList<String> bSikki = new ArrayList<String>();
        ArrayList<String> cSikki = new ArrayList<String>();
        ArrayList<String> dSikki = new ArrayList<String>();
        ArrayList<String> dogruCevap = new ArrayList<String>();
        ArrayList<Integer> soruPuanDegeri = new ArrayList<Integer>();
        ArrayList<String> soruZorlukDerecesi = new ArrayList<String>();
        int kacinciSoruIndeks = -1;
        int soruSiklariIndeks = -1;
        int dogruCevapIndeks = -1;
        int puanDegeriIndeks = -1;
        int zorlukDerecesiIndeks = -1;
        Scanner scanner = new Scanner(System.in);
        int toplamPuan = 0;
         
    @Override
    void soruEkle() {
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sorubankasi.dat",true))){
           do{
               
               //SORU GİR
               System.out.println("Soru ekleme işleminden çıkmak istiyorsanız 7, çıkmak istemiyorsanız 8 giriniz");
               
               int ekle = scanner.nextInt();
               scanner.nextLine();
             
               if(ekle == 7){
                   break;
               }
            
               else if(ekle == 8){
           
            kacinciSoruIndeks++;
            System.out.println("Lütfen" +kacinciSoruIndeks+" .indeks için sorunuzu giriniz");
            testSoru.add(scanner.nextLine());
            oos.writeObject((kacinciSoruIndeks+1) +".Soru-->" + testSoru.get(kacinciSoruIndeks) + "\n");
            
            //4 ADET ŞIK GİR
            soruSiklariIndeks++;
            System.out.println("Lütfen hazırladığınız soru için 4 adet şık giriniz:");
            
            System.out.println("Lütfen A şıkkını giriniz");
            aSikki.add(scanner.nextLine());
            oos.writeObject("A)" + aSikki.get(soruSiklariIndeks)+ "\n");
            
            System.out.println("Lütfen B şıkkını giriniz");
            bSikki.add(scanner.nextLine());
             oos.writeObject("B)" + bSikki.get(soruSiklariIndeks)+ "\n");
           
             System.out.println("Lütfen C şıkkını giriniz");
            cSikki.add(scanner.nextLine());
             oos.writeObject("C)" +cSikki.get(soruSiklariIndeks)+ "\n");
           
             System.out.println("Lütfen D şıkkını giriniz");
            dSikki.add(scanner.nextLine());
             oos.writeObject("D)" +dSikki.get(soruSiklariIndeks)+ "\n");
             
            //DOĞRU YANITI GİR
            dogruCevapIndeks++;
            System.out.println("Lütten sorunuzun doğru yanıtını giriniz");
            dogruCevap.add(scanner.nextLine());
            
            
            //PUAN DEĞERİ 
            puanDegeriIndeks++;
            System.out.println("Lütfen sorunuza bir puan değeri belirleyin");
            soruPuanDegeri.add(scanner.nextInt());
            
            //ZORLUK DERECESİ
            zorlukDerecesiIndeks++;
            System.out.println("Lütfen sorunuza bir zorluk derecesi belirleyin");
            soruZorlukDerecesi.add(scanner.nextLine());
            scanner.nextLine(); //hata olmaması için
           
            for(int m = 0; m <= kacinciSoruIndeks; m++){
                
                toplamPuan += soruPuanDegeri.get(m);
                
                if(toplamPuan <= 100 && toplamPuan <= 110){
                        System.out.println("Soruların toplam puan aralığı 100-110 arasındadır.Programdan çıkılıyor");
                        return;
                 }
            }
           }
          
           }while(true); 
  
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO Exception!");
        }
    }

    @Override
    void soruCikar() {
       
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
            
             TestSinavi test1 = new TestSinavi();
             System.out.println("" + (String)ois.readObject());
             
             System.out.println("Aramak istediğiniz kelimeyi girin");
             String araKelime = scanner.nextLine();
            
            for(int a = 0; a <= kacinciSoruIndeks; a++){
                if(test1.testSoru.get(a).contains(araKelime)){
                    System.out.println("-Kelimenizin geçtiği sorular-");
                    System.out.println(test1.testSoru.get(a));
                    
                    System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                    int soruNumarasi = scanner.nextInt();
                   // test1.testSoru.get(soruNumarasi);
                   test1.testSoru.remove(soruNumarasi - 1);
                   System.out.println(test1.testSoru.get(soruNumarasi - 1) + " sorusu başarı ile silindi.");
                   
                }
            }     
        }   catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            } catch (IOException ex) {
                System.out.println("IO exception!");
            } catch (ClassNotFoundException ex) {
               System.out.println("Class not found exception!");
            }   
    }

    @Override
    void soruListele() {
      
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
            
            TestSinavi test1 = new TestSinavi();
          
            test1 = (TestSinavi)ois.readObject();
        System.out.println("1-Soru metni içinde ara\n2-Soru şıkları içinde ara\n3-Doğru şıkların içinde ara\n" 
                    + "4-Puan üzerinde ara"
                    + "\n5-Zorluk derecesi üzerinden ara\n6-Puana göre ara(Küçükten büyüğe)");
       
        System.out.print("Lütfen arama şeklini seçiniz:");
        
        int secim = scanner.nextInt();
        
        if(secim == 1){
            System.out.println("Aramak istediğiniz kelimeyi girin");
            String araKelime = scanner.nextLine();
            
            for(int a = 0; a <= kacinciSoruIndeks; a++){
                if(test1.testSoru.get(a).contains(araKelime)){
                    System.out.println("-Kelimenizin geçtiği sorular-");
                    System.out.println(test1.testSoru.get(a));
                }
                else
                    System.out.println("Kelimenizin geçtiği bir soru yok");
            }
            
            ois.close();
        }

        else if(secim == 2){
            
            System.out.println("Şıkların içerisinde aramak istediğiniz kelimeyi giriniz:");
            String siklardaKelimeAra = scanner.nextLine();
            System.out.println("-Kelimenizin geçtiği şıklar-");
            
            
            for(int a = 0; a <= soruSiklariIndeks; a++){
                if(aSikki.get(a).contains(siklardaKelimeAra)){
                    System.out.println("A)" + aSikki.get(a));
                }
                else if(bSikki.get(a).contains(siklardaKelimeAra)){
                    System.out.println("B)" + bSikki.get(a));
                }
                else if(cSikki.get(a).contains(siklardaKelimeAra)){
                    System.out.println("C)" + cSikki.get(a));
                }
                else if(dSikki.get(a).contains(siklardaKelimeAra)){
                    System.out.println("D)" + dSikki.get(a));
                }
                else{
                   System.out.println("Aradığınız kelime şıkların içerisinde bulunamadı.");
                    }                                  
            }
            ois.close();
        }
        else if(secim == 3){
            
            System.out.println("-Doğru şıkların içinde aramak istediğiniz kelime-");
            String dogruKelime = scanner.nextLine();
            
            for (int a = 0; a <= dogruCevapIndeks; a++){
                
                if(dogruCevap.get(a).contains(dogruKelime)){
                    System.out.println("Doğru şıkların arasında aradığınız kelime");
                    System.out.println(dogruCevap.get(a));
                }
                else
                    System.out.println("Doğru şıkların arasında girdiğiniz kelime ile eşleşen bir şık bulunamadı.");
            }
            ois.close();
            
        }

        else if(secim == 4){
                System.out.println("Kaç puan değerindeki sorular üzerinden arama yapmak istiyorsunuz");
                int puanAra = scanner.nextInt();
                for(int z = 0; z <= puanDegeriIndeks; z++){
                if(puanAra == soruPuanDegeri.get(z)){ //tekrar bak
                    System.out.println(puanAra + " değerindeki sorular");
                    System.out.println(soruPuanDegeri.get(z));
                    }
                else
                System.out.println("Girdiğiniz puan değeri ile eşleşen sorular bulunmamaktadır.");
              }               
            ois.close();
        }
              else if(secim == 5){
            
            System.out.println("Hangi zorluk derecesine göre arama yapmak istiyorsunuz?");
            String zorlukAra = scanner.nextLine();
            
            for(int a = 0; a <=zorlukDerecesiIndeks; a++){
                if(zorlukAra.equals(test1.soruZorlukDerecesi.get(a))){
                    System.out.println(soruZorlukDerecesi.get(a));          
                }
                else
                    System.out.println("Girdiğiniz zorluk derecesi ile eşleşen sorular bulunmamaktadır.");
            }
            ois.close();   
        }
        
        else if(secim == 6){
            
            //COMPARE TO BAK!           
        }
    
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exception!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception!(Try-Catch deneyebilirsin)");
        }
       
    }
    
 
    
}
