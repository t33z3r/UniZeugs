package _7suchen;

public class LineareSuche {

	// Lineare Suche - mit Exception
	public static int seqSuche(int[] zahlen, int gesucht) {
		int i = 0;
		try {
			while (zahlen[i] != gesucht) {
				i++;
			}
		} catch (Exception e) {
			i = -1;
		}
		return i;
	}
	
	//Lineare Suche für Objekte
	public static int seqSucheObj(Object[] ob, Object gesucht) {
		int i = 0;
        try {
            while (!ob[i].equals(gesucht)) {
                i = i + 1;
            }
        } catch (Exception e) {
            i = -1;
        }
        return i;
	}

	// #############################################################################
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i + 1;
		}
		System.out.println(seqSuche(arr, 4));
	}

}
