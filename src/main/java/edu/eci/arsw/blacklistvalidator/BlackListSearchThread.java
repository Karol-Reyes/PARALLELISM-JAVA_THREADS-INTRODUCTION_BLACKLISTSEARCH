package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;

public class BlackListSearchThread extends Thread {
    private int start;
    private int end;
    private String ipAdd;
    private HostBlacklistsDataSourceFacade validator;
    private LinkedList<Integer> blackListOcurrences = new LinkedList<>();
    
    private int count = 0;
    private int checkedCount = 0;

    private final int[] sharedCount;
    private final int alarmCount;

    public BlackListSearchThread(int start, 
                                int end, 
                                String ipAdd, 
                                HostBlacklistsDataSourceFacade validator,
                                int[] sharedCount, 
                                int alarmCount
    ) {
        this.start = start;
        this.end = end;
        this.ipAdd = ipAdd;
        this.validator = validator;
        this.sharedCount = sharedCount;
        this.alarmCount = alarmCount;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            // Check if the shared count has reached the alarm count
            if (sharedCount[0] >= alarmCount) {
                break;
            }
            checkedCount++;
            if (validator.isInBlackListServer(i, ipAdd)) {
                blackListOcurrences.add(i);
                count++;
                sharedCount[0] = sharedCount[0] + 1;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getCheckedCount() {
        return checkedCount;
    }

    public LinkedList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
