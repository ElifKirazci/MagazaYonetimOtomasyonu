
import java.awt.Component;
import javax.swing.JOptionPane;

public class Validators {

    private Component rootPane;

    public boolean sayiValidator(String alisSatis) {
        for (char sayi : alisSatis.toCharArray()) {
            if (!Character.isDigit(sayi)) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen rakam giriniz.");
                return false;
            }
        }
        return true;
    }

   public boolean harfValidator(String ad) {
        for (char harf : ad.toCharArray()) {
            if (Character.isDigit(harf) || Character.isWhitespace(harf)) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen harf giriniz.");
                return false;
            } 
        } return true;
    }
   public boolean uzunlukTCValidator(String telefon) {
      if(telefon.length() == 11) {
        for (char sayi : telefon.toCharArray()) {
            if (Character.isLetter(sayi) || Character.isWhitespace(sayi)) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen rakam giriniz.");
                return false;
            } 
        } return true;
    } else if (telefon.length() != 11) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen 11 haneli TC No giriniz");
            } return false;
    } 
    public boolean uzunlukTelValidator(String telefon) {
      if(telefon.length() == 10) {
        for (char sayi : telefon.toCharArray()) {
            if (Character.isLetter(sayi) || Character.isWhitespace(sayi)) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen rakam giriniz.");
                return false;
            } 
        } return true;
    } else if (telefon.length() != 10) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen 10 haneli Telefon Numarası giriniz");
            } return false;
    } 
}
