package DatabasePractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorkersDAOTest {

	@Test
	void testAddWorkers() {
		Worker worker = new Worker(1,"Karim Ali","Sales","Gazipur",30000);
		WorkersDAO workersDAO = new WorkersDAO();
		assertEquals(true,workersDAO.addWorkersUsingEmployeeId(worker));
	}

	@Test
	void testDeleWorkers() {
		WorkersDAO workersDAO = new WorkersDAO();
		int id=1;
		assertEquals(true,workersDAO.deleWorkers(id));
	}

	@Test
	void testUpdaWorkers() {
		/**
		 * Update exixting Employee who have EmployeeId
		 * */
		Worker worker = new Worker(1,"Karim Ali","Sales","Gazipur",35000);
		WorkersDAO workersDAO = new WorkersDAO();
		assertEquals(true,workersDAO.updaWorkers(worker));
	}

	@Test
	void testFindWorker() {
		Worker worker = new Worker(1,"Karim Ali","Sales","Gazipur",35000);
		WorkersDAO workersDAO = new WorkersDAO();
		int id =1;
		assertEquals(worker,workersDAO.findWorker(id));
	}

}
