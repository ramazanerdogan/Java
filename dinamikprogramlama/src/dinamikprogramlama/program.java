package dinamikprogramlama;
import java.util.Arrays;
import java.util.List;
public class program {
	 String son;
	 public static void kelimedeDur(List<String> sozluk, String birlesikKelime, String ayrikKelime)// fonksiyon yap�s� ile arrayList ile s�zl��� ,ayr�lmas� gereken c�mleyi ve yazd�rmak istedi�imiz yap�y� i�lem yapmak i�in kullan�c�dan al�yoruz
	    {
	        if (birlesikKelime.length() == 0)//girilen biti�ik c�mlenin uzunlu�u 0 ise ayr�lm�� c�mleyi ekrana yazd�rmak i�in kontrol yap�s� olu�turuyoruz.
	        {
	        	System.out.println(ayrikKelime);//ayr�lm�� c�mleyi ekrana yaz�yoruz
	            return;
	         
	        }
	        for (int i = 1; i <= birlesikKelime.length(); i++)
	        {
	            String ara = birlesikKelime.substring(0, i);//d�ng� yard�m� ile biti�ik c�mleyi par�alara ve indislere ay�r�yoruz ve daha sonra string bir de�i�kene at�yoruz.
	            if (sozluk.contains(ara))//s�rayla par�alara ayr�lan kelimeler s�zl�k adl� arrayListte aran�yor
	            {
	            	kelimedeDur(sozluk, birlesikKelime.substring(i), ayrikKelime + " " + ara);//e�er bulunan par�a arrayListte varsa string de�ere atan�yor ve fonksiyon tekrar �a��r�l�p yaz�lan kelimeden sonraki indisten itibaren tekrar fonksiyon �al��t�r�l�yor ve bulunan kelime string bir veri t�r�ne at�l�p kaydediliyor.
	            }
	        } 
	    }
	public static void main(String[] args) {
		List<String> sozluk = Arrays.asList("ak","al","al","al�","al��","al��ma", "al��mak","al��makta","al��maktan","alma",//kelimeleri par�alara ay�rmak i�in faydalanaca��m�z s�zc�kleri arrayList'e at�yoruz.
			    "almaz","almazlar","an","anla","anlar","ayan","az","azla","azlar","bir","�al","�al�","�al��","�al��ma",
			    "�al��mak","�al��makta","�al��maktan","de","def","dik","dikler","dikleri","ede","ek","eki","Er","Eri",
			    "Eri�","Eri�me","Eri�mek","ev","fi","hedef","hedefi","is","iste","istedi","istedik","istedikleri","i�",
			    "kal","kalma","kalmaz","kalmazlar","kist","kiste","maya","ol","olma","olmaya","olmayan","olmayanla",
			    "olmayanlar","ta","tan","ya","yan","zevk");
		String birlesikKelime = "Eri�mekistedikleribirhedefiolmayanlar�al��maktanzevkalmazlar";//birle�ik c�mleyi string bir ifadeye at�yoruz fonksiyonda kullanmak i�in
		kelimedeDur(sozluk, birlesikKelime, "");//fonksiyonu �a��r�yoruz : burada ilk olarak arrayListe atam�� oldu�umuz s�zl��� yaz�yoruz daha sonra par�alara ay�r�p yazd�rmak i�in kulland���m�z c�mleyi yaz�yoruz ve en son olarakta bo� �ekilde bir metin at�yoruz burada bo� �ekilde kullanmam�z sebebi herhangi bir �ekilde elimizde yazacak bir metin olmad��� i�in bo� �ekilde at�yoruz ve daha sonras�nda fonksiyonda i�lem yaparak doldurulacakt�r.
	}
}