public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        char startSymbol = 'А';
        int startSymbolCode = startSymbol;

        char finishSymbol = 'я';
        int finishSymbolCode = finishSymbol;

        char yoSymbol = 'Ё';
        int yoSymbolCode = yoSymbol;

        char smallYoSymbol = 'ё';
        int smallYoSymbolCode = smallYoSymbol;


        for (int i = startSymbolCode; i <= finishSymbolCode; i++) {
            System.out.println(i + " - " + (char) i);
            if ((char) i == 'Е') {
                System.out.println(yoSymbolCode + " - " + yoSymbol);
            } else if ((char) i == 'е'){
                System.out.println(smallYoSymbolCode + " - " + smallYoSymbol);
            }
        }
    }
}
