package services;

import dao.MetricDAO;

public class MetricsService {
    public void getUsersInEvents() {
        MetricDAO metricDAO = new MetricDAO();
        try {
            metricDAO.getEventsUserParticipated();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
