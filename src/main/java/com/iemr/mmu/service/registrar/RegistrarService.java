package com.iemr.mmu.service.registrar;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BeneficiaryData;

public interface RegistrarService {
	public String getRegWorkList(int servicePointID);

	public BeneficiaryData createBeneficiary(JsonObject benD);

	public Long createBeneficiaryDemographic(JsonObject benD, Long benRegID);

	public Long createBeneficiaryPhoneMapping(JsonObject benD, Long benRegID);

	public Long createBeneficiaryDemographicAdditional(JsonObject benD, Long benRegID);

	public String getQuickSearchBenData(String benID);

}