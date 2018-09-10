package BinarySearch;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Arrays;

public class ClassRandom {
    
    public static void initializemergeSort(int arr[], int l, int n){
        int rendah =l; int tinggi = n;
        if (rendah >= tinggi) {
            return;
        }
        int middle = (rendah + tinggi) / 2;
        initializemergeSort(arr, rendah, middle);
        initializemergeSort(arr, middle + 1, tinggi);
        int end_rendah = middle;
        int start_tinggi = middle + 1;
        while ((l <= end_rendah) && (start_tinggi <= tinggi)) {
            if (arr[rendah] < arr[start_tinggi]) {
                rendah++;
            } else {
                int temp = arr[start_tinggi];
                for (int k = start_tinggi - 1; k >= rendah; k--){
                    arr[k + 1] = arr[k];
                }
                arr[rendah] = temp;
                rendah++;
                end_rendah++;
                start_tinggi++;
            }
        }
    }
    
    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l)
        {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
            {
                return mid;
            }
            if (arr[mid] > x)
            {
                return binarySearch(arr, l, mid - 1, x);
            }
            if (arr[mid] < x)
            {
                return binarySearch(arr, mid + 1, r, x);   
            }
        }
        return -2;
    }
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        ClassRandom ob = new ClassRandom();
        JOptionPane.showMessageDialog(null, "Selamat Datang di Program Pencarian Angka");
        int n = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Banyaknya Angka : "));
        int pilih = Integer.parseInt(JOptionPane.showInputDialog("Pilih Sumber Angka Yang Akan Dicari : \n1. Inputan Dari User "
                + "\n2. Inputan Dari Program \nMasukkan Angka Pilihan : "));
        int arr[] = new int[n];
        if (pilih == 1){
            for (int a = 0; a < n; a++){
                int angka = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Angka Ke-" + (a+1) + " : "));
                arr[a] = angka;
            }
        }
        if (pilih == 2){
            for (int b = 0; b < n; b++){
                arr[b] = new Random().nextInt(301);
            }
        }
        JOptionPane.showMessageDialog(null, "Angka-Angka Inputan : " + (Arrays.toString(arr)));
        initializemergeSort(arr, 0, n-1);
        int cari = Integer.parseInt(JOptionPane.showInputDialog("Angka-Angka Inputan  Yang Sudah Diurutkan : " + (Arrays.toString(arr)) + "\nMasukkan Angka Yang Akan Dicari : "));
        int result = ob.binarySearch(arr, 0, n - 1, cari);
        JOptionPane.showMessageDialog(null, "Angka " + cari + " Berada Pada Posisi Ke-" + (result+1));
    }
}