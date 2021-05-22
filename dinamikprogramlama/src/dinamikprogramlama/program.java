package dinamikprogramlama;
import java.util.Arrays;
import java.util.List;
public class program {
	 String son;
	 public static void kelimedeDur(List<String> sozluk, String birlesikKelime, String ayrikKelime)// fonksiyon yapýsý ile arrayList ile sözlüðü ,ayrýlmasý gereken cümleyi ve yazdýrmak istediðimiz yapýyý iþlem yapmak için kullanýcýdan alýyoruz
	    {
	        if (birlesikKelime.length() == 0)//girilen bitiþik cümlenin uzunluðu 0 ise ayrýlmýþ cümleyi ekrana yazdýrmak için kontrol yapýsý oluþturuyoruz.
	        {
	        	System.out.println(ayrikKelime);//ayrýlmýþ cümleyi ekrana yazýyoruz
	            return;
	         
	        }
	        for (int i = 1; i <= birlesikKelime.length(); i++)
	        {
	            String ara = birlesikKelime.substring(0, i);//döngü yardýmý ile bitiþik cümleyi parçalara ve indislere ayýrýyoruz ve daha sonra string bir deðiþkene atýyoruz.
	            if (sozluk.contains(ara))//sýrayla parçalara ayrýlan kelimeler sözlük adlý arrayListte aranýyor
	            {
	            	kelimedeDur(sozluk, birlesikKelime.substring(i), ayrikKelime + " " + ara);//eðer bulunan parça arrayListte varsa string deðere atanýyor ve fonksiyon tekrar çaðýrýlýp yazýlan kelimeden sonraki indisten itibaren tekrar fonksiyon çalýþtýrýlýyor ve bulunan kelime string bir veri türüne atýlýp kaydediliyor.
	            }
	        } 
	    }
	public static void main(String[] args) {
		List<String> sozluk = Arrays.asList("ak","al","al","alý","alýþ","alýþma", "alýþmak","alýþmakta","alýþmaktan","alma",//kelimeleri parçalara ayýrmak için faydalanacaðýmýz sözcükleri arrayList'e atýyoruz.
			    "almaz","almazlar","an","anla","anlar","ayan","az","azla","azlar","bir","çal","çalý","çalýþ","çalýþma",
			    "çalýþmak","çalýþmakta","çalýþmaktan","de","def","dik","dikler","dikleri","ede","ek","eki","Er","Eri",
			    "Eriþ","Eriþme","Eriþmek","ev","fi","hedef","hedefi","is","iste","istedi","istedik","istedikleri","iþ",
			    "kal","kalma","kalmaz","kalmazlar","kist","kiste","maya","ol","olma","olmaya","olmayan","olmayanla",
			    "olmayanlar","ta","tan","ya","yan","zevk");
		String birlesikKelime = "Eriþmekistedikleribirhedefiolmayanlarçalýþmaktanzevkalmazlar";//birleþik cümleyi string bir ifadeye atýyoruz fonksiyonda kullanmak için
		kelimedeDur(sozluk, birlesikKelime, "");//fonksiyonu çaðýrýyoruz : burada ilk olarak arrayListe atamýþ olduðumuz sözlüðü yazýyoruz daha sonra parçalara ayýrýp yazdýrmak için kullandýðýmýz cümleyi yazýyoruz ve en son olarakta boþ þekilde bir metin atýyoruz burada boþ þekilde kullanmamýz sebebi herhangi bir þekilde elimizde yazacak bir metin olmadýðý için boþ þekilde atýyoruz ve daha sonrasýnda fonksiyonda iþlem yaparak doldurulacaktýr.
	}
}