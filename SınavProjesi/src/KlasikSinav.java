
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KlasikSinav extends SoruBankasi{

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> klasikSoru = new ArrayList<String>();
    ArrayList<String> zorlukDerecesi = new ArrayList<String>();
    int soruIndeks = -1;
    int zorlukDerecesiIndeks = -1;
    
    @Override
    void soruEkle() {
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sorubankasi.dat",true))){
            
            soruIndeks++;
            System.out.println("Lütfen " + soruIndeks + ".indeksteki sorunuzu giriniz");
            klasikSoru.add(scanner.nextLine());

            System.out.println("Lütfen sorunuzun zorluk derecesini (Kolay-Normal-Zor) şeklinde belirtin");
            zorlukDerecesiIndeks++;
            zorlukDerecesi.add(scanner.nextLine());
            
           // oos.writeObject((soruIndeks + 1) + ".Soru-->" + klasikSoru);
            
            for(int z = 0; z <= soruIndeks; z++){
                oos.writeObject((soruIndeks + 1) + ".Soru-->" +klasikSoru.get(z));
            }
            
            for(int x = 0; x <= zorlukDerecesiIndeks; x++){
                oos.writeObject(zorlukDerecesi.get(x));
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception!");
        } catch (IOException ex) {
            System.out.println("IO exceptino!");
        }
       
           
        
        
    }

    @Override
    void soruCikar() {
       
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat"))){
            
            KlasikSinav klasikSinav1 = new KlasikSinav();
            System.out.println("" + (String)ois.readObject());
             
            System.out.println("Aramak istediğiniz kelimeyi girin");
            String araKelime = scanner.nextLine();
            
          
            for(int a = 0; a <= soruIndeks; a++){
                if(klasikSinav1.klasikSoru.contains(araKelime)){
                    System.out.println("-Kelimenizin geçtiği sorular-");
                    System.out.println(klasikSinav1.klasikSoru.get(a));
                    
                    System.out.println("Lütfen silmek istediğiniz sorunun numarasını giriniz");
                    int soruNumarasi = scanner.nextInt();
                    
                    klasikSinav1.klasikSoru.remove(soruNumarasi - 1);
                    System.out.println(klasikSinav1.klasikSoru.get(soruNumarasi - 1) + " sorusu başarı ile silindi.");
                }
            }
            
            
            
            
        } catch (IOException ex) {
            System.out.println("IO exception!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found exception(Try-Catch)Dene");
        }
        
        
    }

    @Override
    void soruListele()
    {
       
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sorubankasi.dat")))
            {
                
                KlasikSinav klasikSinav1 = new KlasikSinav();
                
                System.out.println("" + (String)ois.readObject()); //TRY-CATH DE DENEYEBİLRİSİN
                
            System.out.print("Lütfen arama şeklini seçiniz:");
            System.out.println("1-Soru metni içinde ara\n2-Zorluk derecesi üzerinden ara");
                   
            int secim = scanner.nextInt();
                
                if(secim == 1)
                {
                    System.out.println("Aramak istediğiniz kelimeyi giriniz");
                    String araKelime = scanner.nextLine();
                    
                    for(int a = 0; a <= soruIndeks; a++)
                    {
                        if(klasikSoru.get(a).contains(araKelime))
                        {
                            System.out.println("-Kelimenizin geçtiği sorular-");
                            System.out.println(klasikSoru.get(a));
                        }
                    }
                }
                
                else if(secim == 2){
                    
                System.out.println("Hangi zorluk derecesine göre arama yapmak istiyorsunuz?(Kolay-Normal-Zor)");
                String zorlukAra = scanner.nextLine();
                
                for(int a = 0; a <= zorlukDerecesiIndeks; a++){
                    if(zorlukAra.equals(zorlukDerecesi.get(a))){
                        System.out.println("Hangi kelimei arayacaksınız?");
                          String zorlukKelime = scanner.nextLine();
                          for(int b = 0; b <= zorlukDerecesiIndeks; b++){
                              if(zorlukAra.contains(klasikSoru.get(b))){
                                  System.out.println(klasikSoru.get(b));
                              }
                          }
                    }
                }
                }
                
                
                
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
        } catch (IOException ex) {
                System.out.println("IO exception!");
        } catch (ClassNotFoundException ex) {
                System.out.println("Class not found!(Try-Catch dene)");
        }
            
    }
    
}
