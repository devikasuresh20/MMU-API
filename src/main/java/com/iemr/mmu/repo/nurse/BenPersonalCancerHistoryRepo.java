package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;

@Repository
public interface BenPersonalCancerHistoryRepo extends CrudRepository<BenPersonalCancerHistory, Long> {

	@Query(" SELECT bph from BenPersonalCancerHistory bph  WHERE bph.beneficiaryRegID = :benRegID AND bph.benVisitID = :benVisitID ")
	public BenPersonalCancerHistory getBenPersonalHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Transactional
	@Modifying
	@Query("update BenPersonalCancerHistory set tobaccoUse=:tobaccoUse, startAge_year=:startAge_year, endAge_year=:endAge_year, typeOfTobaccoProduct=:typeOfTobaccoProduct,"
			+ " quantityPerDay=:quantityPerDay, isFilteredCigaerette=:isFilteredCigaerette, isCigaretteExposure=:isCigaretteExposure, isBetelNutChewing=:isBetelNutChewing, "
			+ " durationOfBetelQuid=:durationOfBetelQuid, alcoholUse=:alcoholUse, ssAlcoholUsed=:ssAlcoholUsed, frequencyOfAlcoholUsed=:frequencyOfAlcoholUsed,"
			+ " modifiedBy=:modifiedBy where iD=:iD")
	public int updateBenPersonalCancerHistory(@Param("tobaccoUse") String tobaccoUse,
			@Param("startAge_year") Integer startAge_year, @Param("endAge_year") Integer endAge_year,
			@Param("typeOfTobaccoProduct") String typeOfTobaccoProduct, @Param("quantityPerDay") Integer quantityPerDay,
			@Param("isFilteredCigaerette") Boolean isFilteredCigaerette,
			@Param("isCigaretteExposure") Boolean isCigaretteExposure,
			@Param("isBetelNutChewing") Boolean isBetelNutChewing,
			@Param("durationOfBetelQuid") Integer durationOfBetelQuid, @Param("alcoholUse") String alcoholUse,
			@Param("ssAlcoholUsed") Boolean ssAlcoholUsed,
			@Param("frequencyOfAlcoholUsed") String frequencyOfAlcoholUsed, @Param("modifiedBy") String modifiedBy,
			@Param("iD") Long iD);
}