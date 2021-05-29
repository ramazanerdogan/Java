
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SinavYap{

    void sinavBasla(SinavYap sinavYap1){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hangi tarzda sınav olacaksınız?");
        System.out.println("---1)-Test---2)Klasik---3)Karışık---");
        
        int sinavTarzi = scanner.nextInt();
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sinavlar.dat"))){
          
           if(sinavTarzi == 1){
         
             TestSinavi test1 = new TestSinavi();
             test1 = (TestSinavi)ois.readObject();
             System.out.println(test1); 
              
            }

        else if(sinavTarzi == 2){
            KlasikSinav klasikSinav = new KlasikSinav();
            klasikSinav = (KlasikSinav)ois.readObject();
               System.out.println(klasikSinav);
        }
        
        else if(sinavTarzi == 3){
            KarisikSinav karisikSinav = new KarisikSinav();
            karisikSinav = (KarisikSinav)ois.readObject();
               System.out.println(karisikSinav);
        }       
        else
            System.out.println("Hatalı Seçim!");   
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
      
        }//TRY-CATCH 
    public static void main(String[] args) {
     
          /*SinavYap sinavv = new SinavYap();
          sinavv.sinavBasla(sinavv);*/
     
          SinavYap ilkSinav = new SinavYap();
          ilkSinav.sinavBasla(ilkSinav);        
    }
     

 }


