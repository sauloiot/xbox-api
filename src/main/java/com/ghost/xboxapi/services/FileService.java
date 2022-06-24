package com.ghost.xboxapi.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FileService {
    public List<String> csvReader(String file)  {
        AtomicReference<Integer> quantidade = new AtomicReference<>(0);
        List<String> ids = new ArrayList<>();
        List<String> idsLimpos = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try {
            try (Scanner scanner = new Scanner(new File(file));) {
                while (scanner.hasNextLine()) {
                    records.add(getRecordFromLine(scanner.nextLine()));
                }
            }
            for (List<String> record: records) {
                record.forEach(r-> {
                    ids.add(r);
                    quantidade.set(quantidade.get() + 1);
                });
            }

            for (String id: ids) {
                String rm1 = id.replace("https://displaycatalog.mp.microsoft.com/v7.0/products?bigIds=","");
                String rm2 = rm1.replace("&market=BR&languages=pt-br&MS-CV=DGU1mcuYo0WMMp+F.1","");
                idsLimpos.add(rm2);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return idsLimpos;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
