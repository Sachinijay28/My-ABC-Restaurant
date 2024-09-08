package com.abc.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.ReservationsDAO;
import com.abc.model.Reservation;


@WebServlet("/reservations")
public class ReservationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private ReservationsDAO reservationsDAO;

    public void init() {
        reservationsDAO = new ReservationsDAO();
    }

    
    public ReservationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                addReservation(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateReservation(request, response);
                break;
            case "delete":
                deleteReservation(request, response);
                break;
            default:
                listReservations(request, response);
                break;
        }
    }

    private void addReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int guests = Integer.parseInt(request.getParameter("guests"));

        Reservation newReservation = new Reservation(name, email, phone, date, time, guests);
        reservationsDAO.addReservation(newReservation);
        response.sendRedirect("ReservationsServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reservation existingReservation = reservationsDAO.getReservation(id);
        request.setAttribute("reservation", existingReservation);
        request.getRequestDispatcher("editReservation.jsp").forward(request, response);
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int guests = Integer.parseInt(request.getParameter("guests"));

        Reservation reservation = new Reservation(id, name, email, phone, date, time, guests);
        reservationsDAO.updateReservation(reservation);
        response.sendRedirect("ReservationsServlet?action=list");
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reservationsDAO.deleteReservation(id);
        response.sendRedirect("ReservationsServlet?action=list");
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> reservations = reservationsDAO.getAllReservations();
     //   reservations.add(new Reservation("Test Name", "test@email.com", "1234567890", "2023-06-01", "18:00", 2));
         System.out.println("Reservations in servlet: " + reservations.size());
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("viewreservations.jsp").forward(request, response);
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
