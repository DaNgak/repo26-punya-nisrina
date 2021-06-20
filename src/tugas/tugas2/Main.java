package tugas.tugas2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    List<Mahasiswa> mhs = new ArrayList<>();
    List<MataKuliah> mk = new ArrayList<>();
    List<Nilai> nli = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main obj = new Main();
        int pilih;
        obj.setDataMHSdanMatkul();
        do {
        System.out.println("*******************");
        System.out.println("Sistem Pengolahan Data Nilai Mahasiswa Semester");
        System.out.println("*******************");
        System.out.println("1. Input Nilai");
        System.out.println("2. Tampil Nilai");
        System.out.println("3. Mencari Nilai Mahasiswa");
        System.out.println("4. Urut Data Nilai");
        System.out.println("5. Keluar");
        System.out.print("Pilih : ");
        pilih = input.nextInt();
            if (pilih == 1) {
                obj.menusatu();
            } else if (pilih == 2) {
                obj.menudua();
            } else if (pilih == 3) {
                obj.menutiga();
            } else if (pilih == 4) {
                obj.menuempat();
            } else {
                System.out.println("Byeee.....");
            }
        } while (pilih >= 1 && pilih <= 4);
    }

    void setDataMHSdanMatkul(){
        mhs.add(new Mahasiswa("20001", "Thalhah", "021xxx"));
        mhs.add(new Mahasiswa("20002", "Zubair", "021xxx"));
        mhs.add(new Mahasiswa("20003", "Abdur-Rahman", "021xxx"));
        mhs.add(new Mahasiswa("20004", "Sa' ad", "021xxx"));
        mhs.add(new Mahasiswa("20005", "Sa' id", "021xxx"));
        mhs.add(new Mahasiswa("20006", "Ubaidah", "021xxx"));
        mk.add(new MataKuliah("00001", "Internet of Things", "3"));
        mk.add(new MataKuliah("00002", "Algoritma dan Struktur Data", "2"));
        mk.add(new MataKuliah("00003", "Algoritma dan Pemrograman", "2"));
        mk.add(new MataKuliah("00004", "Praktikum Algoritma dan Struktur Data", "3"));
        mk.add(new MataKuliah("00005", "Praktikum Algoritma dan Pemrograman", "3"));
    }

    void menusatu(){
        input.nextLine();
        System.out.println("Masukkan Data ");
        System.out.print("Kode  : ");
        String kode = input.next();
        System.out.print("Nilai : ");
        float nilai = input.nextFloat();
        for (Mahasiswa mahasiswa : mhs) {
            System.out.println(mahasiswa.nim + "\t" + mahasiswa.nama + "\t" + mahasiswa.telepon);
        }
        boolean ketemu = true;
        String pilihmahasiswa; int konfirmasi2 = 0;
        do {
            System.out.print("Pilih Mahasiswa by NIM : ");
            pilihmahasiswa = input.next();
            for (Mahasiswa mahasiswa : mhs) {
                if (pilihmahasiswa.equals(mahasiswa.nim)) {
                    ketemu = false;
                    konfirmasi2++;
                }
            }
            if (konfirmasi2 == 0) {
                System.out.println("Data Kode NIM Tidak Ditemukan");
            }
        } while (ketemu);

        for (MataKuliah matakuliah : mk) {
            System.out.println(matakuliah.kode+"\t" + matakuliah.matakuliah + "\t" + matakuliah.sks);
        }
        boolean ketemu2 = true;
        String pilihmatakuliah; int konfirmasi = 0;
        do {
            System.out.print("Pilih Mata Kuliah by Kode : ");
            pilihmatakuliah = input.next();
            for (MataKuliah mklh : mk) {
                if (pilihmatakuliah.equals(mklh.kode)) {
                    ketemu2 = false;
                    konfirmasi++;
                    
                } 
            }
            if (konfirmasi == 0) {
                System.out.println("Data Kode Matakuliah Tidak Ditemukan");
            }
        } while (ketemu2);
        nli.add(new Nilai(kode, nilai, pilihmatakuliah, pilihmahasiswa));
    }

    void menudua(){
        System.out.println("NIM\tNama Mahasiswa\tMata Kuliah\tSKS\tNilai");
        nli.forEach(nilaisatuan -> {
            System.out.print(nilaisatuan.nimmhs+"\t");
            for (Mahasiswa mahasiswa : mhs) {
                if(mahasiswa.nim.equals(nilaisatuan.nimmhs)){
                    System.out.print(mahasiswa.nama+"\t");
                }
            }
            for (MataKuliah matkul : mk) {
                if (matkul.kode.equals(nilaisatuan.kodematakuliah)) {
                    System.out.print(matkul.matakuliah + "\t" + matkul.sks+"\t");
                }
            }
            System.out.println(nilaisatuan.nilai);
        });
    }

    void menutiga(){
        menudua();
        System.out.print("Masukkan Data Mahasiswa[nim] : ");
        String caridata = input.next();
        int konfirmasi3 = 0;
        for (Nilai carinilai : nli) {
            if (carinilai.nimmhs.equals(caridata)) {
                System.out.print(carinilai.nimmhs+"\t");
                for (Mahasiswa mahasiswa : mhs) {
                    if(mahasiswa.nim.equals(carinilai.nimmhs)){
                        System.out.print(mahasiswa.nama+"\t");
                    }
                }
                for (MataKuliah matkul : mk) {
                    if (matkul.kode.equals(carinilai.kodematakuliah)) {
                        System.out.print(matkul.matakuliah + "\t" + matkul.sks+"\t");
                    }
                }
                System.out.println(carinilai.nilai);
                konfirmasi3++;
            }
        }
        if (konfirmasi3 == 0) {
            System.out.println("Data Dengan NIM " + caridata + " Tidak Ditemukan");
        }
    }

    void menuempat(){
        for (int i = 0; i < nli.size()-1; i++) {
            for (int j = 0; j < nli.size()-i-1; j++) {
                if (nli.get(j).nilai > nli.get(j+1).nilai){
                    float swap = nli.get(j).nilai;
                    nli.get(j).nilai = nli.get(j+1).nilai;
                    nli.get(j+1).nilai = swap;
                }
            }
        }
        menudua();
    }
}
