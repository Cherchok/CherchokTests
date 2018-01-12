package DuplicateFinder;


import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class DuplicateFinderImpl implements DuplicateFinder {

    DuplicateFinderImpl(){}

    public boolean process (File sourceFile, File targetFile)
    {
        List<String> list=new ArrayList<String>();
        /** Читаем из файла строки в обобщенній список*/
        try
        {
            Scanner in=new Scanner(sourceFile);
            while (in.hasNext()) list.add(in.nextLine());
            in.close();
        }
        catch(Exception e){System.out.print(e.getMessage()); return false;}

        /** Формируем из полученного выше списка list упорядоченную карту:
         ключ - элемент list, значение - кол-во повторений єтого элемента в list*/
        Map<String,Integer> map=new TreeMap<String,Integer>();
        for(String s:list)
        {
            map.put(s,Collections.frequency(list, s));
        }

        /** Пишем в конец файла из map*/
        try
        {
            FileWriter out=new FileWriter (targetFile,true);
            for(Map.Entry<String,Integer> entry:map.entrySet())
                out.write(entry.getKey()+" "+"["+entry.getValue()+"]"+"\n");
            out.close();
        }
        catch(Exception e){System.out.print(e.getMessage()); return false;}

        return true;
    }
}
