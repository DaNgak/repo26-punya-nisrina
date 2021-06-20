package tugas.tugas1;
import java.util.Scanner;
import java.util.Stack;
public class tugas1 {
    public static void main(String[] args) {
        Stack<Buku> stk = new Stack<>();
        Scanner input = new Scanner(System.in);
        int pilih;
        do{
            System.out.println("Menu Awal dan Tambah Data(Push)");
            System.out.println("Data Buku Perpustakaan");
            System.out.println("1. Entry Judul Buku");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Cek Buku Teratas");
            System.out.println("4. Info Semua Judul Buku");
            System.out.println("5. Keluar");
            System.out.println("************************");
            System.out.print("Pilih     : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                input.nextLine();
                System.out.print("Isbn      : ");
                String isbn = input.nextLine();
                System.out.print("Judul     : ");
                String judul = input.nextLine();
                System.out.print("Terbit    : ");
                String terbit = input.nextLine();
                System.out.print("Penerbit  : ");
                String penerbit = input.nextLine();
                Buku objBuku = new Buku(isbn, judul, terbit, penerbit);
                stk.push(objBuku);
            } else if(pilih == 2){
                System.out.println("Element Yang Dihapus = " + stk.peek().isbn + "\tJudul = " + stk.peek().judul + "\tTerbit = " + stk.peek().terbit + "\tPenerbit = " + stk.peek().penerbit);
                stk.pop();
            } else if(pilih == 3){
                System.out.println("Element Teratas = Isbn = " + stk.peek().isbn + "\tJudul = " + stk.peek().judul + "\tTerbit = " + stk.peek().terbit + "\tPenerbit = " + stk.peek().penerbit);
            } else if(pilih == 4){
                stk.forEach(bk -> {
                    System.out.println("Isbn = " + bk.isbn + "\tJudul = " + bk.judul + "\tTerbit = " + bk.terbit + "\tPenerbit = " + bk.penerbit);
                });
            } else {
                System.out.println("Byeee...");
            }
        } while (pilih >= 1 && pilih<= 4);
    }
}
