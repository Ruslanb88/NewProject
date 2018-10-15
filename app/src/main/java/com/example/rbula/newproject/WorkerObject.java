package com.example.rbula.newproject;

import java.util.List;

public class WorkerObject {
    public static class Worker {
        public String worker;
        public int time;
        public int lastSeen;
        public int reportedHashrate;
        public double currentHashrate;
        public int validShares;
        public int invalidShares;
        public int staleShares;
        public double averageHashrate;
    }

    public String status;
    public List<Worker> data;
}
