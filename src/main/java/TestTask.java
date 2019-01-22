import java.util.*;

/**
 * Created by me on 21.01.2019.
 */
public class TestTask {
    private int[] sourceData;
    private int  countStep, lengthCycle;

    public TestTask(String str) {
        sourceData = StringToIntArray(str);
    }

    public void doIt(){
        List<int[]> lstData = new ArrayList<>();
        Set<List<Integer>> setData = new HashSet<>();
        lstData.add(sourceData);
        setData.add(arrToList(sourceData));

        while(true) {
            int[] curData = sourceData.clone();
            int indexMaxValue =  findIndexMaxNumber(curData);
            int saveNum = curData[indexMaxValue];
            curData[indexMaxValue] = 0;

            //целое от деления
            int plusNum = saveNum/curData.length;
            //остаток от деления
            int plusOstatok = saveNum%curData.length;
            //распределение числа с правой стороны
            for (int i = indexMaxValue + 1; i < curData.length; i++) {
                if (plusNum>0) curData[i] += plusNum;
                if (plusOstatok>0) {
                    curData[i] += 1;
                    plusOstatok--;
                }
            }
            //распределение числа с левой стороны
            for (int i = 0; i <= indexMaxValue; i++) {
                if (plusNum>0) curData[i] += plusNum;
                if (plusOstatok>0) {
                    curData[i] += 1;
                    plusOstatok--;
                }
            }


            boolean exit=false;
            boolean addToSet= setData.add(arrToList(curData));
            if(!addToSet){
                //сравнение полученного массива с другими, полученными ранее
                for(int i=0; i <lstData.size();i++){
                    if (compareArrays(lstData.get(i), curData)) {
                        countStep = lstData.size();
                        lengthCycle =  lstData.size()- i;
                        exit = true;
                        break;
                    }
                }
            }

            lstData.add(curData);
            sourceData = curData;
            if (exit) break;
        }

        //Вывод результата
        /*
        for(int[] array:lstData){
            printArray(array);
        }*/

    }

    public int getCountStep() {
        return countStep;
    }


    public int getLengthCycle() {
        return lengthCycle;
    }



    //функция для сравнения массивов на равенство
    static boolean compareArrays(int[] array1, int[] array2){
        for(int i=0; i < array1.length;i++){
            if(array1[i] != array2[i]) return false;
        }
        return true;
    }

    //функция поиска индекса элемента, имеющего максимальное значение в массиве
    static int findIndexMaxNumber(int[] array){
        int maxIndex= 0;
        for (int i=1;i<array.length;i++){
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //функция печати массива в заданном виде
    static void printArray(int[] array){
        for(int i=0;i <array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    static int[] StringToIntArray(String str){
        String[] items = str.split(" ");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                System.out.print("\nНеверный формат чисел");
            }
        }
        return  results;
    }

    static List<Integer> arrToList(int[] arr){
         List<Integer> intList = new ArrayList<>();
        for (int i : arr)
        {
            intList.add(i);
        }
        return intList;
    }
}
