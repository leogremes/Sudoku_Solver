class Main
{
	public static void main(String[] args)
	{
		int[][] sudoku = 
			{{  6 , 0 , 9 ,		8 , 7 , 1 ,		0 , 0 , 0 },
			 {  0 , 5 , 0 ,		3 , 0 , 0 ,		6 , 0 , 0 },
			 {  0 , 0 , 0 ,		0 , 0 , 0 ,		1 , 0 , 9 },

			 {  0 , 0 , 5 ,		0 , 0 , 7 ,		0 , 0 , 0 },
			 {  0 , 0 , 3 ,		0 , 1 , 0 ,		0 , 6 , 0 },
			 {  0 , 0 , 0 ,		6 , 0 , 0 ,		4 , 0 , 0 },

			 {  9 , 0 , 0 ,		0 , 6 , 4 ,		0 , 5 , 0 },
			 {  4 , 3 , 0 ,		0 , 0 , 0 ,		2 , 0 , 0 },
			 {  0 , 8 , 0 ,		0 , 0 , 2 ,		9 , 0 , 7 }};

		Solver solver = new Solver();

		if (solver.solve(sudoku))
			solver.printSudoku(sudoku);
		else
			System.out.println("Não tem uma solução");
	}
}
