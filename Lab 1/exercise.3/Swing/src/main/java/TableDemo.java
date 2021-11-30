import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

/** Przyklad uzycia komponentu JTable identyczny z SimpleTableDemo
 *	oprocz dostosowania modelu tabeli.
 * 	
 *	TableDemo.java nie wymaga dodatkowych plikow
 * <br>
 * <a href="http://java.sun.com/docs/books/tutorial/uiswing/components/example-1dot4">
 * http://java.sun.com/docs/books/tutorial/uiswing/components/example-1dot4</a>
 */
public class TableDemo extends JPanel {
    private boolean DEBUG = false;

	/** konstruktor bezparametrowy */
    public TableDemo() {
        //wybrany GridLayout
        super(new GridLayout(1,0));
		
		//utworzenie tabeli o dostosowanym modelu
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //utworzenie panelu przewijalnego i dodanie do niego tabeli
        JScrollPane scrollPane = new JScrollPane(table);
        
        //dodanie przewijalnego panelu do panelu aplikacji
        add(scrollPane);
    }

	/** wewnetrzna klasa definiujaca model tabeli */
    class MyTableModel extends AbstractTableModel {
    	/** naglowki kolumn */
        private String[] columnNames = {"First Name",
                                        "Last Name",
                                        "Sport",
                                        "# of Years",
                                        "Vegetarian"};
        /** dane zawarte w tabeli */
        private Object[][] data = {
            {"Mary", "Campione",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"Alison", "Huml",
             "Rowing", new Integer(3), new Boolean(true)},
            {"Kathy", "Walrath",
             "Knitting", new Integer(2), new Boolean(false)},
            {"Sharon", "Zakhour",
             "Speed reading", new Integer(20), new Boolean(true)},
            {"Philip", "Milne",
             "Pool", new Integer(10), new Boolean(false)}
        };
        
		/** @return ilosc kolumn w tabeli */
        public int getColumnCount() {
            return columnNames.length;
        }
		
		/** @return ilosc pozycji w tabeli */
        public int getRowCount() {
            return data.length;
        }

		/** @return tytul kolumny o numerze <code>col</code> 
		 *	@param col nr kolumny 
		 */
        public String getColumnName(int col) {
            return columnNames[col];
        }

		/** @return zawartosc wybranej komorki w tabeli 
		 *	@param row nr wiersza wybranej komorki
		 *	@param col nr kolumny wybranej komorki
		 */
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /**	metoda uzyta do okreslenia domyslnego sposobu edycji i
         *	prezentacji dla kazdej z komorek
         *	gdyby nie zostala zaimplementowana ostatnia kolumna 
         *	zawieralaby tekst ("true"/"false") zamiast checkbox'ow
         *	@return klasa wybranej kolumny
         *	@param c nr wybranej kolumny
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /**	metoda implementowana gdy wystepuja
         *	komorki o zawartosci mozliwej do edycji
         * 	@true gdy wybrana komorke mozna edytowac, false gdy nie mozna
         *	@param row nr wiersza wybranej komorki
         *	@param col nr kolumny wybranej komorki
         */
        public boolean isCellEditable(int row, int col) {
            //uwaga - adres komorki jest staly, niezaleznie
            //od aktualnego polozenia na ekranie
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /** metoda implementowana gdy dace w tabeli moga sie zmieniac
         *	@param value
         *	@param row nr wiersza wybranej komorki
         *	@param col nr kolumny wybranej komorki
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
            
			//wlasciwa aktualizacja
            data[row][col] = value;
            //wywolanie metody generujacej zdarzenie informujace
            //o zmianie zawartosci komorki
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }
		
		/** metoda wypisujaca informacje kontrolne */
        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

    /**	utworzenie i pokazanie GUI 
     *	dla zapewnienia bezpieczenstwa ponizsza metoda 
     *	powinna byc wywolywana z watku rozsylajacego zdarzenia   
     */
    private static void createAndShowGUI() {        
        //ustawienie ladnego wygladu okien
        JFrame.setDefaultLookAndFeelDecorated(true);

		//utworzenie i przygotowanie okna
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //utworzenie i przygotowanie panelu
        TableDemo newContentPane = new TableDemo();
        //panel widoczny
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

        //wyswietlenie okna
        frame.pack();
        frame.setVisible(true);
    }
	
	/** metoda glowna 
	 *	@param args pomijany
	 */
    public static void main(String[] args) {
        //zadaniem watku rozsylajacego zdarzenia bedzie 
        //utworzenie GUI aplikacji
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
