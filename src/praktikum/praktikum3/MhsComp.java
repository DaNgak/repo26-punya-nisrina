package praktikum.praktikum3;

import java.util.Comparator;
public class MhsComp implements Comparator<Mahasiswa>{
public int compare(Mahasiswa mhs1, Mahasiswa mhs2) {
        if (mhs1.nim == mhs2.nim) {
            return 0;
        } else {
            return -1;
        }
    
}
@Override
    public Comparator<Mahasiswa> reversed() {
        return Comparator.super.reversed();
    }
}
