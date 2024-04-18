package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

public class GroupNumbers
{
    // Group numbers

    //този код създава матрица, която съдържа числата от масива numbers { 1, 4, 113, 55, 3, 1, 2, 66, 557, 124, 2 }, разделени по остатъците при деление на 3:

//   ред 0 |   3  66
//   ред 1 |   1   4  55 124
//   ред 2 |   2 113 557   2

    public static void main(String[] args)
    {
        int[] numbers = { 1, 4, 113, 55, 3, 1, 2, 66, 557, 124, 2 };
        int[] sizes = new int[3]; // Създаване на масив sizes с дължина 3, който ще съдържа размерите на всяка от трите "реда" в резултатната матрица.
        int[] offsets = new int[3]; // създаване на масив offsets с дължина 3, който ще показва текущата позиция за всяка "ред" в матрицата.
        for (int number : numbers)
        {
            int reminder = number % 3; //Всеки елемент от масива се делите на 3 и се изчислява остатъка: 0/ 1/ 2
            sizes[reminder] ++; //Размерът на "реда" в матрицата, който съответства на остатъка, се увеличава.
        }

        //Създаване на двумерен масив numbersByRemainder, който ще съдържа числата, разделени по остатъците при деление на 3.
        int[][] numbersByRemainder =
                {new int[sizes[0]], new int[sizes[1]], new int[sizes[2]] };

        //изцикляме отново инпут масива, целочислено го делим на 3, според remainder-а вадим индекса за големия масив
        for (int number : numbers)
        {
            int remainder = number % 3;  //Всяко число се разделя на 3, и остатъка се използва за да се определи на кой "ред" да се постави числото.
            int index = offsets[remainder]; //до къде сме стигнали с последния елемент в съответния ред, например offsets[0] - на 0 ред добавените елементи, стартира от 0 и се увеличава с 1, съответно и на 1-ви ред и на 2-ри ред
            numbersByRemainder[remainder][index] = number; //позиция за ред=remainder (0,1 или 2) и колона=index: в реда колко добавени до момента елементи (до достигане на максималната дължина на реда)
            offsets[remainder]++;
        }

        //принтиране на резултата
        for (int row = 0; row < numbersByRemainder.length; row++)
        {
            for (int column = 0; column < numbersByRemainder[row].length; column++)
            {
                System.out.print(numbersByRemainder[row][column] + " ");
            }
            System.out.println();
        }

    }
}
