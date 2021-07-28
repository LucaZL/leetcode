/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/12
 */
public class NumberXXX {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9 };
        int[] b = {2,4,6,8,};
        System.out.println(findMiddle(a, b, a.length + b.length, 0, a.length - 1, 0, b.length - 1));
    }

    public static int findMiddle(int[] m, int[] n, int k, int mStart, int mEnd, int nStart, int nEnd) {
        if(m[mStart] >= n[nEnd]) {
            return k >= (nEnd - nStart + 1) ? m[mStart + k - (nEnd - nStart + 1)] : n[nStart + k];
        }else if(m[mEnd] <= n[nStart]) {
            return k >= (mEnd - mStart + 1) ? n[nStart + k - (mEnd - mStart + 1)] : m[mStart + k];
        }

        if(k == 2) {
            return (m[mEnd] + n[nEnd]) / 2;
        }else if(k <= 1) {

        }

        int km = mEnd;
        int kn = nEnd;
        if(mStart < mEnd) {
            km = (mStart + mEnd) / 2;
        }else{
            mStart = mEnd;
        }
        if(nStart < nEnd) {
            kn = (nStart + nEnd) / 2;
        }else{
            nStart = nEnd;
        }
        if(m[km] > n[kn]) {
            if(kn < nEnd) {
                kn = kn + 1;
            }
            k = k - (mEnd - km) - (kn - nStart);
            return findMiddle(m, n, k, mStart, km, kn, nEnd);
        }else{
            if(km < mEnd) {
                km = km + 1;
            }
            k = k - (km - mStart) - (nEnd - kn);
            return findMiddle(m, n, k, km, mEnd, nStart, kn);
        }

    }
}
