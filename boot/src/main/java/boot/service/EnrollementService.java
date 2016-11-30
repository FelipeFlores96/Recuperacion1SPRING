package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.EnrollementRepository;
import boot.model.Enrollement;


	@Service @Transactional
	public class EnrollementService {
		private final EnrollementRepository enrollementRepository;

		public EnrollementService(EnrollementRepository enrollementRepository) {
			super();
			this.enrollementRepository = enrollementRepository;
		}
		public List<Enrollement> findAll(){
			List<Enrollement> enrollements = new ArrayList<Enrollement>();
			for (Enrollement enrollement : enrollementRepository.findAll()){
				enrollements.add(enrollement);
			}
			return enrollements;
		}
		
		public void save(Enrollement enrollement){
			enrollementRepository.save(enrollement);
		}
		
		public void delete(int id){
			enrollementRepository.delete(id);
		}
		
		public Enrollement findEnrollement(int id){
			return enrollementRepository.findOne(id);
		}
	}

		
	