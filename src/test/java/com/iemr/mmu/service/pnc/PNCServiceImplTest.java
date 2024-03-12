package com.iemr.mmu.service.pnc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.benFlowStatus.I_bendemographics;
import com.iemr.mmu.data.location.Districts;
import com.iemr.mmu.data.location.States;
import com.iemr.mmu.data.masterdata.registrar.GenderMaster;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.data.provider.ProviderServiceMapping;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.data.tele_consultation.TeleconsultationRequestOBJ;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.location.ZoneDistrictMapping;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class PNCServiceImplTest {
  @Mock
  private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

  @Mock
  private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

  @Mock
  private CommonDoctorServiceImpl commonDoctorServiceImpl;

  @Mock
  private CommonNurseServiceImpl commonNurseServiceImpl;

  @Mock
  private LabTechnicianServiceImpl labTechnicianServiceImpl;

  @Mock
  private PNCDoctorServiceImpl pNCDoctorServiceImpl;

  @Mock
  private PNCNurseServiceImpl pNCNurseServiceImpl;

  @InjectMocks
  private PNCServiceImpl pNCServiceImpl;

  @Mock
  private TeleConsultationServiceImpl teleConsultationServiceImpl;

 
  @Test
  void testSavePNCNurseData() throws Exception {
    // Arrange, Act and Assert
    assertNull(pNCServiceImpl.savePNCNurseData(new JsonObject()));
    assertNull(pNCServiceImpl.savePNCNurseData(null));
  }

 
  @Test
  void testSavePNCNurseData2() throws Exception {
    // Arrange
    I_bendemographics i_bendemographics = new I_bendemographics();
    i_bendemographics.setDistrictBranchID(1);
    i_bendemographics.setDistrictBranchName("janedoe/featurebranch");
    i_bendemographics.setDistrictID(1);
    i_bendemographics.setDistrictName("District Name");
    i_bendemographics.setServicePointID(1);
    i_bendemographics.setServicePointName("Service Point Name");

    GenderMaster m_gender = new GenderMaster();
    m_gender.setDeleted(true);
    m_gender.setGenderID((short) 1);
    m_gender.setGenderName("Gender Name");

    BeneficiaryFlowStatus beneficiaryFlowStatus = new BeneficiaryFlowStatus();
    beneficiaryFlowStatus.setAge("Age");
    beneficiaryFlowStatus.setAgeVal(42);
    beneficiaryFlowStatus.setAgentId("42");
    beneficiaryFlowStatus.setAuth("Auth");
    beneficiaryFlowStatus.setBenArrivedFlag(true);
    beneficiaryFlowStatus.setBenFlowID(1L);
    beneficiaryFlowStatus.setBenImage("Ben Image");
    beneficiaryFlowStatus.setBenName("Ben Name");
    beneficiaryFlowStatus.setBenPhoneMaps(new ArrayList<>());
    beneficiaryFlowStatus.setBenVisitCode(1L);
    beneficiaryFlowStatus.setBenVisitDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setBenVisitID(1L);
    beneficiaryFlowStatus.setBenVisitNo((short) 1);
    beneficiaryFlowStatus.setBen_age_val(42);
    beneficiaryFlowStatus.setBeneficiaryID(1L);
    beneficiaryFlowStatus.setBeneficiaryName("Beneficiary Name");
    beneficiaryFlowStatus.setBeneficiaryRegID(1L);
    beneficiaryFlowStatus.setBloodGroup("Blood Group");
    beneficiaryFlowStatus.setConsultantID(1);
    beneficiaryFlowStatus.setConsultantName("Consultant Name");
    beneficiaryFlowStatus.setConsultationDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    beneficiaryFlowStatus.setCreatedDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setDeleted(true);
    beneficiaryFlowStatus.setDistrictID(1);
    beneficiaryFlowStatus.setDistrictName("District Name");
    beneficiaryFlowStatus.setDoctorFlag((short) 1);
    beneficiaryFlowStatus.setFatherName("Father Name");
    beneficiaryFlowStatus.setFirstName("Jane");
    beneficiaryFlowStatus.setGenderID((short) 1);
    beneficiaryFlowStatus.setGenderName("Gender Name");
    beneficiaryFlowStatus.setI_bendemographics(i_bendemographics);
    beneficiaryFlowStatus.setIsCaseSheetdownloaded(true);
    beneficiaryFlowStatus.setIsTMVisitDone(true);
    beneficiaryFlowStatus.setLabIteration((short) 1);
    beneficiaryFlowStatus.setLab_technician_flag((short) 1);
    beneficiaryFlowStatus.setLastName("Doe");
    beneficiaryFlowStatus.setM_gender(m_gender);
    beneficiaryFlowStatus.setModified_by("Jan 1, 2020 9:00am GMT+0100");
    beneficiaryFlowStatus.setModified_date(mock(Timestamp.class));
    beneficiaryFlowStatus.setNurseFlag((short) 1);
    beneficiaryFlowStatus.setOncologist_flag((short) 1);
    beneficiaryFlowStatus.setParkingPlaceID(1);
    beneficiaryFlowStatus.setPassToNurse(true);
    beneficiaryFlowStatus.setPharmacist_flag((short) 1);
    beneficiaryFlowStatus.setPreferredPhoneNum("6625550144");
    beneficiaryFlowStatus.setProcessed("Processed");
    beneficiaryFlowStatus.setProviderServiceMapID(1);
    beneficiaryFlowStatus.setProviderServiceMapId(1);
    beneficiaryFlowStatus.setRadiologist_flag((short) 1);
    beneficiaryFlowStatus.setReferredVisitCode(1L);
    beneficiaryFlowStatus.setRegistrationDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setReservedForChange("Reserved For Change");
    beneficiaryFlowStatus.setServiceDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setServicePointID(1);
    beneficiaryFlowStatus.setServicePointName("Service Point Name");
    beneficiaryFlowStatus.setSpecialist_flag((short) 1);
    beneficiaryFlowStatus.setSpouseName("Spouse Name");
    beneficiaryFlowStatus.setSyncedBy("Synced By");
    beneficiaryFlowStatus.setSyncedDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setVanID(1);
    beneficiaryFlowStatus.setVanNo("Van No");
    beneficiaryFlowStatus.setVanSerialNo(1L);
    beneficiaryFlowStatus.setVehicalNo("Vehical No");
    beneficiaryFlowStatus.setVillageID(1);
    beneficiaryFlowStatus.setVillageName("Village Name");
    beneficiaryFlowStatus.setVisitCategory("Visit Category");
    beneficiaryFlowStatus.setVisitCode(1L);
    beneficiaryFlowStatus.setVisitDate(mock(Timestamp.class));
    beneficiaryFlowStatus.setVisitReason("Just cause");
    beneficiaryFlowStatus.setVisitSession(1);
    beneficiaryFlowStatus.setdOB(mock(Timestamp.class));
    beneficiaryFlowStatus.settCRequestDate(mock(Timestamp.class));
    beneficiaryFlowStatus.settCSpecialistUserID(1);
    beneficiaryFlowStatus.settC_SpecialistLabFlag((short) 1);
    when(beneficiaryFlowStatusRepo.checkExistData(Mockito.<Long>any(), Mockito.<Short>any()))
            .thenReturn(beneficiaryFlowStatus);

    JsonObject requestOBJ = new JsonObject();
    requestOBJ.add("visitDetails", new JsonArray(3));

    // Act
    Long actualSavePNCNurseDataResult = pNCServiceImpl.savePNCNurseData(requestOBJ);

    // Assert
    verify(beneficiaryFlowStatusRepo).checkExistData(Mockito.<Long>any(), Mockito.<Short>any());
    assertEquals(0L, actualSavePNCNurseDataResult.longValue());
  }

  
  @Test
  void testSavePNCDoctorData() throws Exception {
    // Arrange, Act and Assert
    assertNull(pNCServiceImpl.savePNCDoctorData(null, "JaneDoe"));
  }

  @Test
  void testSaveBenVisitDetails() throws Exception {
    // Arrange
    JsonObject visitDetailsOBJ = new JsonObject();

    CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
    nurseUtilityClass.setBenFlowID(1L);
    nurseUtilityClass.setBenVisitID(1L);
    nurseUtilityClass.setBeneficiaryID(1L);
    nurseUtilityClass.setBeneficiaryRegID(1L);
    nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    nurseUtilityClass.setFacilityID(1);
    nurseUtilityClass.setIsSpecialist(true);
    nurseUtilityClass.setParkingPlaceID(1);
    nurseUtilityClass.setProviderServiceMapID(1);
    nurseUtilityClass.setServiceID((short) 1);
    nurseUtilityClass.setSessionID(1);
    nurseUtilityClass.setVanID(1);
    nurseUtilityClass.setVisitCode(1L);

    // Act and Assert
    assertTrue(pNCServiceImpl.saveBenVisitDetails(visitDetailsOBJ, nurseUtilityClass).isEmpty());
  }

  @Test
  void testSaveBenVisitDetails2() throws Exception {
    // Arrange
    CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
    nurseUtilityClass.setBenFlowID(1L);
    nurseUtilityClass.setBenVisitID(1L);
    nurseUtilityClass.setBeneficiaryID(1L);
    nurseUtilityClass.setBeneficiaryRegID(1L);
    nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    nurseUtilityClass.setFacilityID(1);
    nurseUtilityClass.setIsSpecialist(true);
    nurseUtilityClass.setParkingPlaceID(1);
    nurseUtilityClass.setProviderServiceMapID(1);
    nurseUtilityClass.setServiceID((short) 1);
    nurseUtilityClass.setSessionID(1);
    nurseUtilityClass.setVanID(1);
    nurseUtilityClass.setVisitCode(1L);

    // Act and Assert
    assertTrue(pNCServiceImpl.saveBenVisitDetails(null, nurseUtilityClass).isEmpty());
  }

  @Test
  void testSaveBenVisitDetails3() throws Exception {
    // Arrange
    JsonObject visitDetailsOBJ = new JsonObject();
    visitDetailsOBJ.add("Property", new JsonArray(3));

    CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
    nurseUtilityClass.setBenFlowID(1L);
    nurseUtilityClass.setBenVisitID(1L);
    nurseUtilityClass.setBeneficiaryID(1L);
    nurseUtilityClass.setBeneficiaryRegID(1L);
    nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    nurseUtilityClass.setFacilityID(1);
    nurseUtilityClass.setIsSpecialist(true);
    nurseUtilityClass.setParkingPlaceID(1);
    nurseUtilityClass.setProviderServiceMapID(1);
    nurseUtilityClass.setServiceID((short) 1);
    nurseUtilityClass.setSessionID(1);
    nurseUtilityClass.setVanID(1);
    nurseUtilityClass.setVisitCode(1L);

    // Act and Assert
    assertTrue(pNCServiceImpl.saveBenVisitDetails(visitDetailsOBJ, nurseUtilityClass).isEmpty());
  }

  @Test
  void testSaveBenPNCHistoryDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCHistoryDetails(new JsonObject(), 1L, 1L).longValue());
    assertEquals(1L, pNCServiceImpl.saveBenPNCHistoryDetails(null, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCHistoryDetails2() throws Exception {
    // Arrange
    JsonObject pncHistoryOBJ = new JsonObject();
    pncHistoryOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCHistoryDetails(pncHistoryOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCHistoryDetails3() throws Exception {
    // Arrange
    JsonObject pncHistoryOBJ = new JsonObject();
    pncHistoryOBJ.addProperty("pastHistory", (String) null);

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCHistoryDetails(pncHistoryOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCDetails(new JsonObject(), 1L, 1L).longValue());
    assertEquals(1L, pNCServiceImpl.saveBenPNCDetails(null, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCDetails2() throws Exception {
    // Arrange
    JsonObject pncDetailsOBJ = new JsonObject();
    pncDetailsOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCDetails(pncDetailsOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCDetails3() throws Exception {
    // Arrange
    JsonObject pncDetailsOBJ = new JsonObject();
    pncDetailsOBJ.addProperty("pNCDeatils", (String) null);

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenPNCDetails(pncDetailsOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1L, actualSaveBenPNCVitalDetailsResult.longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails2() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(0L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertNull(actualSaveBenPNCVitalDetailsResult);
  }

  @Test
  void testSaveBenPNCVitalDetails3() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(null);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertNull(actualSaveBenPNCVitalDetailsResult);
  }

  @Test
  void testSaveBenPNCVitalDetails4() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(0L);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertNull(actualSaveBenPNCVitalDetailsResult);
  }

  @Test
  void testSaveBenPNCVitalDetails5() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(null);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertNull(actualSaveBenPNCVitalDetailsResult);
  }

  @Test
  void testSaveBenPNCVitalDetails6() throws Exception {
    // Arrange, Act and Assert
    assertNull(pNCServiceImpl.saveBenPNCVitalDetails(null, 1L, 1L));
  }

  @Test
  void testSaveBenPNCVitalDetails7() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.add("Property", new JsonArray(3));

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(vitalDetailsOBJ, 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1L, actualSaveBenPNCVitalDetailsResult.longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails8() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.addProperty("Property", "42");

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(vitalDetailsOBJ, 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1L, actualSaveBenPNCVitalDetailsResult.longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails9() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.addProperty("Property", Integer.valueOf(1));

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(vitalDetailsOBJ, 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1L, actualSaveBenPNCVitalDetailsResult.longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails10() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenReturn(1L);
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
            .thenReturn(1L);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.addProperty("Property", true);

    // Act
    Long actualSaveBenPNCVitalDetailsResult = pNCServiceImpl.saveBenPNCVitalDetails(vitalDetailsOBJ, 1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1L, actualSaveBenPNCVitalDetailsResult.longValue());
  }

  @Test
  void testSaveBenPNCVitalDetails11() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.saveBenPNCVitalDetails(new JsonObject(), 1L, 1L));
    verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
  }

  @Test
  void testSaveBenExaminationDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenExaminationDetails(new JsonObject(), 1L, 1L).longValue());
    assertEquals(1L, pNCServiceImpl.saveBenExaminationDetails(null, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenExaminationDetails2() throws Exception {
    // Arrange
    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.add("yyyy-MM-dd'T'HH:mm:ss.SSS", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenExaminationDetails(examinationDetailsOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenExaminationDetails3() throws Exception {
    // Arrange
    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenExaminationDetails(examinationDetailsOBJ, 1L, 1L).longValue());
  }

  @Test
  void testSaveBenExaminationDetails4() throws Exception {
    // Arrange
    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.addProperty("generalExamination", (String) null);

    // Act and Assert
    assertEquals(1L, pNCServiceImpl.saveBenExaminationDetails(examinationDetailsOBJ, 1L, 1L).longValue());
  }

  @Test
  @Disabled("TODO: Complete this test")
  void testGetBenVisitDetailsFrmNursePNC() throws Exception {

    // Arrange
    States states = new States();
    states.setCountryID(1);
    states.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    states.setCreatedDate(mock(Timestamp.class));
    states.setDeleted(true);
    states.setLastModDate(mock(Timestamp.class));
    states.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    states.setStateCode("MD");
    states.setStateID(1);
    states.setStateIName("MD");
    states.setStateName("MD");

    ZoneDistrictMapping zoneDistrictMapping = new ZoneDistrictMapping();
    zoneDistrictMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    zoneDistrictMapping.setCreatedDate(mock(Timestamp.class));
    zoneDistrictMapping.setDeleted(true);
    zoneDistrictMapping.setDistrictID(1);
    zoneDistrictMapping.setDistrictsSet(new HashSet<>());
    zoneDistrictMapping.setLastModDate(mock(Timestamp.class));
    zoneDistrictMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    zoneDistrictMapping.setProcessed("Processed");
    zoneDistrictMapping.setProviderServiceMapID(1);
    zoneDistrictMapping.setZoneDistrictMapID(1);
    zoneDistrictMapping.setZoneID(1);

    Districts m_district = new Districts();
    m_district.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    m_district.setCreatedDate(mock(Timestamp.class));
    m_district.setDeleted(true);
    m_district.setDistrictID(1);
    m_district.setDistrictName("District Name");
    m_district.setLastModDate(mock(Timestamp.class));
    m_district.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    m_district.setStateID(1);
    m_district.setStates(states);
    m_district.setZoneDistrictMapping(zoneDistrictMapping);

    States state = new States();
    state.setCountryID(1);
    state.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    state.setCreatedDate(mock(Timestamp.class));
    state.setDeleted(true);
    state.setLastModDate(mock(Timestamp.class));
    state.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    state.setStateCode("MD");
    state.setStateID(1);
    state.setStateIName("MD");
    state.setStateName("MD");

    ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping();
    providerServiceMapping.setAddress("42 Main St");
    providerServiceMapping.setCityID(1);
    providerServiceMapping.setCountryID(1);
    providerServiceMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    providerServiceMapping.setCreatedDate(mock(Timestamp.class));
    providerServiceMapping.setDeleted(true);
    providerServiceMapping.setDistrictBlockID(1);
    providerServiceMapping.setDistrictID(1);
    providerServiceMapping.setLastModDate(mock(Timestamp.class));
    providerServiceMapping.setM_district(m_district);
    providerServiceMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    providerServiceMapping.setProviderServiceMapID(1);
    providerServiceMapping.setServiceID((short) 1);
    providerServiceMapping.setServiceProviderID(1);
    providerServiceMapping.setState(state);
    providerServiceMapping.setStateID(1);
    providerServiceMapping.setStatusID(1);

    BeneficiaryVisitDetail beneficiaryVisitDetail = new BeneficiaryVisitDetail();
    beneficiaryVisitDetail.setBenVisitID(1L);
    beneficiaryVisitDetail.setBeneficiaryRegID(1L);
    beneficiaryVisitDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    beneficiaryVisitDetail.setCreatedDate(mock(Timestamp.class));
    beneficiaryVisitDetail.setDeleted(true);
    beneficiaryVisitDetail.setFileIDs(new String[]{"File IDs"});
    beneficiaryVisitDetail.setFiles(new ArrayList<>());
    beneficiaryVisitDetail.setHealthFacilityLocation("Health Facility Location");
    beneficiaryVisitDetail.setHealthFacilityType("Health Facility Type");
    beneficiaryVisitDetail.setLastModDate(mock(Timestamp.class));
    beneficiaryVisitDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    beneficiaryVisitDetail.setParkingPlaceID(1);
    beneficiaryVisitDetail.setPregnancyStatus("Pregnancy Status");
    beneficiaryVisitDetail.setProcessed("Processed");
    beneficiaryVisitDetail.setProviderServiceMapID(1);
    beneficiaryVisitDetail.setProviderServiceMapping(providerServiceMapping);
    beneficiaryVisitDetail.setReportFilePath("/directory/foo.txt");
    beneficiaryVisitDetail.setReservedForChange("Reserved For Change");
    beneficiaryVisitDetail.setServiceProviderName("Service Provider Name");
    beneficiaryVisitDetail.setSyncedBy("Synced By");
    beneficiaryVisitDetail.setSyncedDate(mock(Timestamp.class));
    beneficiaryVisitDetail.setVanID(1);
    beneficiaryVisitDetail.setVanSerialNo(1L);
    beneficiaryVisitDetail.setVehicalNo("Vehical No");
    beneficiaryVisitDetail.setVisitCategory("Visit Category");
    beneficiaryVisitDetail.setVisitCategoryID(1);
    beneficiaryVisitDetail.setVisitCode(1L);
    beneficiaryVisitDetail.setVisitDateTime(mock(Timestamp.class));
    beneficiaryVisitDetail.setVisitFlowStatusFlag("Visit Flow Status Flag");
    beneficiaryVisitDetail.setVisitNo((short) 1);
    beneficiaryVisitDetail.setVisitReason("Just cause");
    beneficiaryVisitDetail.setVisitReasonID((short) 1);
    beneficiaryVisitDetail.setrCHID("R CHID");
    when(commonNurseServiceImpl.getCSVisitDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(beneficiaryVisitDetail);
    when(commonNurseServiceImpl.getBenChiefComplaints(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Ben Chief Complaints");

    // Act
    pNCServiceImpl.getBenVisitDetailsFrmNursePNC(1L, 1L);
  }

  @Test
  void testGetBenPNCDetailsFrmNursePNC() {
    // Arrange
    when(pNCNurseServiceImpl.getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Pnc Care Details");

    // Act
    String actualBenPNCDetailsFrmNursePNC = pNCServiceImpl.getBenPNCDetailsFrmNursePNC(1L, 1L);

    // Assert
    verify(pNCNurseServiceImpl).getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals("{PNCCareDetail=Pnc Care Details}", actualBenPNCDetailsFrmNursePNC);
  }

  @Test
  void testGetBenPNCDetailsFrmNursePNC2() {
    // Arrange
    when(pNCNurseServiceImpl.getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenThrow(new RuntimeException("PNCCareDetail"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.getBenPNCDetailsFrmNursePNC(1L, 1L));
    verify(pNCNurseServiceImpl).getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any());
  }

  @Test
  @Disabled("TODO: Complete this test")
  void testGetBenHistoryDetails() {

    // Arrange
    BenChildDevelopmentHistory benChildDevelopmentHistory = new BenChildDevelopmentHistory();
    benChildDevelopmentHistory.setBenVisitID(1L);
    benChildDevelopmentHistory.setBeneficiaryRegID(1L);
    benChildDevelopmentHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benChildDevelopmentHistory.setCreatedDate(mock(Timestamp.class));
    benChildDevelopmentHistory.setDeleted(true);
    benChildDevelopmentHistory.setDevelopmentProblem("Development Problem");
    benChildDevelopmentHistory.setDevelopmentProblems(new ArrayList<>());
    benChildDevelopmentHistory.setFineMotorMilestone("Fine Motor Milestone");
    benChildDevelopmentHistory.setFineMotorMilestones(new ArrayList<>());
    benChildDevelopmentHistory.setGrossMotorMilestone("Gross Motor Milestone");
    benChildDevelopmentHistory.setGrossMotorMilestones(new ArrayList<>());
    benChildDevelopmentHistory.setID(1L);
    benChildDevelopmentHistory.setIsFMMAttained(true);
    benChildDevelopmentHistory.setIsGMMAttained(true);
    benChildDevelopmentHistory.setIsLMAttained(true);
    benChildDevelopmentHistory.setIsSMAttained(true);
    benChildDevelopmentHistory.setLanguageMilestone("en");
    benChildDevelopmentHistory.setLanguageMilestones(new ArrayList<>());
    benChildDevelopmentHistory.setLastModDate(mock(Timestamp.class));
    benChildDevelopmentHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benChildDevelopmentHistory.setParkingPlaceID(1);
    benChildDevelopmentHistory.setProcessed("Processed");
    benChildDevelopmentHistory.setProviderServiceMapID(1);
    benChildDevelopmentHistory.setReservedForChange("Reserved For Change");
    benChildDevelopmentHistory.setSocialMilestone("Social Milestone");
    benChildDevelopmentHistory.setSocialMilestones(new ArrayList<>());
    benChildDevelopmentHistory.setSyncedBy("Synced By");
    benChildDevelopmentHistory.setSyncedDate(mock(Timestamp.class));
    benChildDevelopmentHistory.setVanSerialNo(1L);
    benChildDevelopmentHistory.setVehicalNo("Vehical No");
    benChildDevelopmentHistory.setVisitCode(1L);

    BenFamilyHistory benFamilyHistory = new BenFamilyHistory();
    benFamilyHistory.setBenVisitID(1L);
    benFamilyHistory.setBeneficiaryRegID(1L);
    benFamilyHistory.setCaptureDate(mock(Date.class));
    benFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyHistory.setDeleted(true);
    benFamilyHistory.setDiseaseType("Disease Type");
    benFamilyHistory.setDiseaseTypeID((short) 1);
    benFamilyHistory.setFamilyDiseaseList(new ArrayList<>());
    benFamilyHistory.setFamilyMember("Family Member");
    benFamilyHistory.setGeneticDisorder("Genetic Disorder");
    benFamilyHistory.setID(1L);
    benFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
    benFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
    benFamilyHistory.setLastModDate(mock(Timestamp.class));
    benFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyHistory.setOtherDiseaseType("Other Disease Type");
    benFamilyHistory.setParkingPlaceID(1);
    benFamilyHistory.setProcessed("Processed");
    benFamilyHistory.setProviderServiceMapID(1);
    benFamilyHistory.setReservedForChange("Reserved For Change");
    benFamilyHistory.setSnomedCode("Snomed Code");
    benFamilyHistory.setSnomedTerm("Snomed Term");
    benFamilyHistory.setSyncedBy("Synced By");
    benFamilyHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyHistory.setVanID(1);
    benFamilyHistory.setVanSerialNo(1L);
    benFamilyHistory.setVehicalNo("Vehical No");
    benFamilyHistory.setVisitCode(1L);

    BenMedHistory benMedHistory = new BenMedHistory();
    benMedHistory.setBenMedHistoryID(1L);
    benMedHistory.setBenVisitID(1L);
    benMedHistory.setBeneficiaryRegID(1L);
    benMedHistory.setCaptureDate(mock(Date.class));
    benMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benMedHistory.setCreatedDate(mock(Timestamp.class));
    benMedHistory.setDeleted(true);
    benMedHistory.setDrugComplianceID((short) 1);
    benMedHistory.setIllnessType("Illness Type");
    benMedHistory.setIllnessTypeID(1);
    benMedHistory.setIllness_Type("Illness Type");
    benMedHistory.setLastModDate(mock(Timestamp.class));
    benMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benMedHistory.setOtherIllnessType("Other Illness Type");
    benMedHistory.setOtherSurgeryType("Other Surgery Type");
    benMedHistory.setOther_Illness_Type("Other Illness Type");
    benMedHistory.setOther_Surgery_Type("Other Surgery Type");
    benMedHistory.setParkingPlaceID(1);
    benMedHistory.setPastIllness(new ArrayList<>());
    benMedHistory.setPastSurgery(new ArrayList<>());
    benMedHistory.setProcessed("Processed");
    benMedHistory.setProviderServiceMapID(1);
    benMedHistory.setReservedForChange("Reserved For Change");
    benMedHistory.setSurgeryID(1);
    benMedHistory.setSurgeryType("Surgery Type");
    benMedHistory.setSurgery_Type("Surgery Type");
    benMedHistory.setSyncedBy("Synced By");
    benMedHistory.setSyncedDate(mock(Timestamp.class));
    benMedHistory.setVanID(1);
    benMedHistory.setVanSerialNo(1L);
    benMedHistory.setVehicalNo("Vehical No");
    benMedHistory.setVisitCode(1L);
    benMedHistory.setYear_Of_Illness(mock(Date.class));
    benMedHistory.setYear_Of_Surgery(mock(Date.class));
    benMedHistory.setYearofIllness(mock(Timestamp.class));
    benMedHistory.setYearofSurgery(mock(Timestamp.class));

    BenMenstrualDetails benMenstrualDetails = new BenMenstrualDetails();
    benMenstrualDetails.setBenMenstrualID(1);
    benMenstrualDetails.setBenVisitID(1L);
    benMenstrualDetails.setBeneficiaryRegID(1L);
    benMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
    benMenstrualDetails.setCaptureDate(mock(Date.class));
    benMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benMenstrualDetails.setCreatedDate(mock(Timestamp.class));
    benMenstrualDetails.setCycleLength("Cycle Length");
    benMenstrualDetails.setDeleted(true);
    benMenstrualDetails.setLastModDate(mock(Timestamp.class));
    benMenstrualDetails.setLmp_date(mock(Date.class));
    benMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
    benMenstrualDetails.setMenstrualCycleStatusID((short) 1);
    benMenstrualDetails.setMenstrualCyclelengthID((short) 1);
    benMenstrualDetails.setMenstrualFlowDurationID((short) 1);
    benMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
    benMenstrualDetails.setMenstrualProblemList(new ArrayList<>());
    benMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benMenstrualDetails.setParkingPlaceID(1);
    benMenstrualDetails.setProblemName("Problem Name");
    benMenstrualDetails.setProcessed("Processed");
    benMenstrualDetails.setProviderServiceMapID(1);
    benMenstrualDetails.setRegularity("Regularity");
    benMenstrualDetails.setReservedForChange("Reserved For Change");
    benMenstrualDetails.setSyncedBy("Synced By");
    benMenstrualDetails.setSyncedDate(mock(Timestamp.class));
    benMenstrualDetails.setVanID(1);
    benMenstrualDetails.setVanSerialNo(1L);
    benMenstrualDetails.setVehicalNo("Vehical No");
    benMenstrualDetails.setVisitCode(1L);
    benMenstrualDetails.setlMPDate(mock(Timestamp.class));

    BenPersonalHabit benPersonalHabit = new BenPersonalHabit();
    benPersonalHabit.setAlcoholDuration(mock(Timestamp.class));
    benPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
    benPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
    benPersonalHabit.setAlcoholList(new ArrayList<>());
    benPersonalHabit.setAlcoholType("Alcohol Type");
    benPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
    benPersonalHabit.setAlcohol_use_duration(mock(Date.class));
    benPersonalHabit.setAllergicList(new ArrayList<>());
    benPersonalHabit.setAllergyStatus("Allergy Status");
    benPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
    benPersonalHabit.setBenPersonalHabitID(1);
    benPersonalHabit.setBenVisitID(1L);
    benPersonalHabit.setBeneficiaryRegID(1L);
    benPersonalHabit.setCaptureDate(mock(Date.class));
    benPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalHabit.setCreatedDate(mock(Timestamp.class));
    benPersonalHabit.setDeleted(true);
    benPersonalHabit.setDietaryType("Dietary Type");
    benPersonalHabit.setLastModDate(mock(Timestamp.class));
    benPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalHabit.setNumberperDay((short) 1);
    benPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
    benPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
    benPersonalHabit.setParkingPlaceID(1);
    benPersonalHabit.setPhysicalActivityType("Physical Activity Type");
    benPersonalHabit.setProcessed("Processed");
    benPersonalHabit.setProviderServiceMapID(1);
    benPersonalHabit.setReservedForChange("Reserved For Change");
    benPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
    benPersonalHabit.setRiskySexualPracticesStatus('A');
    benPersonalHabit.setSyncedBy("Synced By");
    benPersonalHabit.setSyncedDate(mock(Timestamp.class));
    benPersonalHabit.setTobaccoList(new ArrayList<>());
    benPersonalHabit.setTobaccoUseDuration(mock(Timestamp.class));
    benPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
    benPersonalHabit.setTobaccoUseType("Tobacco Use Type");
    benPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
    benPersonalHabit.setTobacco_use_duration(mock(Date.class));
    benPersonalHabit.setVanID(1);
    benPersonalHabit.setVanSerialNo(1L);
    benPersonalHabit.setVehicalNo("Vehical No");
    benPersonalHabit.setVisitCode(1L);

    ChildFeedingDetails childFeedingDetails = new ChildFeedingDetails();
    childFeedingDetails.setBenMotherID(1L);
    childFeedingDetails.setBenVisitID(1L);
    childFeedingDetails.setBeneficiaryRegID(1L);
    childFeedingDetails.setChildID(1L);
    childFeedingDetails.setCompFeedStartAge("Comp Feed Start Age");
    childFeedingDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    childFeedingDetails.setCreatedDate(mock(Timestamp.class));
    childFeedingDetails.setDeleted(true);
    childFeedingDetails.setFoodIntoleranceStatus("Food Intolerance Status");
    childFeedingDetails.setID(1L);
    childFeedingDetails.setLastModDate(mock(Timestamp.class));
    childFeedingDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    childFeedingDetails.setNoOfCompFeedPerDay("No Of Comp Feed Per Day");
    childFeedingDetails.setParkingPlaceID(1);
    childFeedingDetails.setProcessed("Processed");
    childFeedingDetails.setProviderServiceMapID(1);
    childFeedingDetails.setReservedForChange("Reserved For Change");
    childFeedingDetails.setSyncedBy("Synced By");
    childFeedingDetails.setSyncedDate(mock(Timestamp.class));
    childFeedingDetails.setTypeOfFeed("Type Of Feed");
    childFeedingDetails.setTypeofFoodIntolerance("Typeof Food Intolerance");
    childFeedingDetails.setVanSerialNo(1L);
    childFeedingDetails.setVehicalNo("Vehical No");
    childFeedingDetails.setVisitCode(1L);

    PerinatalHistory perinatalHistory = new PerinatalHistory();
    perinatalHistory.setBenVisitID(1L);
    perinatalHistory.setBeneficiaryRegID(1L);
    perinatalHistory.setBirthWeight_kg(10.0d);
    perinatalHistory.setComplicationAtBirth("Complication At Birth");
    perinatalHistory.setComplicationAtBirthID((short) 1);
    perinatalHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    perinatalHistory.setCreatedDate(mock(Timestamp.class));
    perinatalHistory.setDeleted(true);
    perinatalHistory.setDeliveryPlaceID((short) 1);
    perinatalHistory.setDeliveryTypeID((short) 1);
    perinatalHistory.setGestation("Gestation");
    perinatalHistory.setID(1L);
    perinatalHistory.setLastModDate(mock(Timestamp.class));
    perinatalHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    perinatalHistory.setOtherComplicationAtBirth("Other Complication At Birth");
    perinatalHistory.setOtherPlaceOfDelivery("Other Place Of Delivery");
    perinatalHistory.setParkingPlaceID(1);
    perinatalHistory.setPlaceOfDelivery("Place Of Delivery");
    perinatalHistory.setProcessed("Processed");
    perinatalHistory.setProviderServiceMapID(1);
    perinatalHistory.setReservedForChange("Reserved For Change");
    perinatalHistory.setSyncedBy("Synced By");
    perinatalHistory.setSyncedDate(mock(Timestamp.class));
    perinatalHistory.setTypeOfDelivery("Type Of Delivery");
    perinatalHistory.setVanSerialNo(1L);
    perinatalHistory.setVehicalNo("Vehical No");
    perinatalHistory.setVisitCode(1L);

    WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail = new WrapperChildOptionalVaccineDetail();
    wrapperChildOptionalVaccineDetail.setBenVisitID(1L);
    wrapperChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
    wrapperChildOptionalVaccineDetail.setChildOptionalVaccineList(new ArrayList<>());
    wrapperChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    wrapperChildOptionalVaccineDetail.setParkingPlaceID(1);
    wrapperChildOptionalVaccineDetail.setProviderServiceMapID(1);
    wrapperChildOptionalVaccineDetail.setVanID(1);
    wrapperChildOptionalVaccineDetail.setVisitCode(1L);

    WrapperComorbidCondDetails wrapperComorbidCondDetails = new WrapperComorbidCondDetails();
    wrapperComorbidCondDetails.setBenVisitID(1L);
    wrapperComorbidCondDetails.setBeneficiaryRegID(1L);
    wrapperComorbidCondDetails.setComorbidityConcurrentConditionsList(new ArrayList<>());
    wrapperComorbidCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    wrapperComorbidCondDetails.setParkingPlaceID(1);
    wrapperComorbidCondDetails.setProviderServiceMapID(1);
    wrapperComorbidCondDetails.setVanID(1);
    wrapperComorbidCondDetails.setVisitCode(1L);

    WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = new WrapperFemaleObstetricHistory();
    wrapperFemaleObstetricHistory.setBenVisitID(1L);
    wrapperFemaleObstetricHistory.setBeneficiaryRegID(1L);
    wrapperFemaleObstetricHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    wrapperFemaleObstetricHistory.setFemaleObstetricHistoryList(new ArrayList<>());
    wrapperFemaleObstetricHistory.setParkingPlaceID(1);
    wrapperFemaleObstetricHistory.setProviderServiceMapID(1);
    wrapperFemaleObstetricHistory.setTotalNoOfPreg((short) 1);
    wrapperFemaleObstetricHistory.setVanID(1);
    wrapperFemaleObstetricHistory.setVisitCode(1L);

    WrapperImmunizationHistory wrapperImmunizationHistory = new WrapperImmunizationHistory();
    wrapperImmunizationHistory.setBenVisitID(1L);
    wrapperImmunizationHistory.setBeneficiaryRegID(1L);
    wrapperImmunizationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    wrapperImmunizationHistory.setImmunizationList(new ArrayList<>());
    wrapperImmunizationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    wrapperImmunizationHistory.setParkingPlaceID(1);
    wrapperImmunizationHistory.setProviderServiceMapID(1);
    wrapperImmunizationHistory.setVanID(1);
    wrapperImmunizationHistory.setVisitCode(1L);

    WrapperMedicationHistory wrapperMedicationHistory = new WrapperMedicationHistory();
    wrapperMedicationHistory.setBenVisitID(1L);
    wrapperMedicationHistory.setBeneficiaryRegID(1L);
    wrapperMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    wrapperMedicationHistory.setMedicationHistoryList(new ArrayList<>());
    wrapperMedicationHistory.setParkingPlaceID(1);
    wrapperMedicationHistory.setProviderServiceMapID(1);
    wrapperMedicationHistory.setVanID(1);
    wrapperMedicationHistory.setVisitCode(1L);
    when(commonNurseServiceImpl.getDevelopmentHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(benChildDevelopmentHistory);
    when(commonNurseServiceImpl.getFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(benFamilyHistory);
    when(commonNurseServiceImpl.getPastHistoryData(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(benMedHistory);
    when(commonNurseServiceImpl.getMenstrualHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(benMenstrualDetails);
    when(commonNurseServiceImpl.getPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(benPersonalHabit);
    when(commonNurseServiceImpl.getFeedingHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(childFeedingDetails);
    when(commonNurseServiceImpl.getPerinatalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(perinatalHistory);
    when(commonNurseServiceImpl.getChildOptionalVaccineHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(wrapperChildOptionalVaccineDetail);
    when(commonNurseServiceImpl.getComorbidityConditionsHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(wrapperComorbidCondDetails);
    when(commonNurseServiceImpl.getFemaleObstetricHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(wrapperFemaleObstetricHistory);
    when(commonNurseServiceImpl.getImmunizationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(wrapperImmunizationHistory);
    when(commonNurseServiceImpl.getMedicationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(wrapperMedicationHistory);

    // Act
    pNCServiceImpl.getBenHistoryDetails(1L, 1L);
  }

  @Test
  void testGetBeneficiaryVitalDetails() {
    // Arrange
    when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Beneficiary Physical Anthropometry Details");
    when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Beneficiary Physical Vital Details");

    // Act
    String actualBeneficiaryVitalDetails = pNCServiceImpl.getBeneficiaryVitalDetails(1L, 1L);

    // Assert
    verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals(
            "{benAnthropometryDetail=Beneficiary Physical Anthropometry Details, benPhysicalVitalDetail=Beneficiary"
                    + " Physical Vital Details}",
            actualBeneficiaryVitalDetails);
  }

  @Test
  void testGetBeneficiaryVitalDetails2() {
    // Arrange
    when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenThrow(new RuntimeException("benAnthropometryDetail"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.getBeneficiaryVitalDetails(1L, 1L));
    verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(), Mockito.<Long>any());
  }

  @Test
  @Disabled("TODO: Complete this test")
  void testGetPNCExaminationDetailsData() {

    // Arrange
    PhyGeneralExamination phyGeneralExamination = new PhyGeneralExamination();
    phyGeneralExamination.setBenVisitID(1L);
    phyGeneralExamination.setBeneficiaryRegID(1L);
    phyGeneralExamination.setBuiltAndAppearance("Built And Appearance");
    phyGeneralExamination.setClubbing("Clubbing");
    phyGeneralExamination.setCoherence("Coherence");
    phyGeneralExamination.setComfortness("Comfortness");
    phyGeneralExamination.setConsciousness("Consciousness");
    phyGeneralExamination.setCooperation("Cooperation");
    phyGeneralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    phyGeneralExamination.setCreatedDate(mock(Timestamp.class));
    phyGeneralExamination.setCyanosis("Cyanosis");
    phyGeneralExamination.setDangerSigns("Danger Signs");
    phyGeneralExamination.setDeleted(true);
    phyGeneralExamination.setEdema("Edema");
    phyGeneralExamination.setEdemaType("Edema Type");
    phyGeneralExamination.setExtentOfEdema("Extent Of Edema");
    phyGeneralExamination.setFoetalMovements("Foetal Movements");
    phyGeneralExamination.setGait("Gait");
    phyGeneralExamination.setID(1L);
    phyGeneralExamination.setJaundice("Jaundice");
    phyGeneralExamination.setLastModDate(mock(Timestamp.class));
    phyGeneralExamination.setLymphadenopathy("Lymphadenopathy");
    phyGeneralExamination.setLymphnodesInvolved("Lymphnodes Involved");
    phyGeneralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    phyGeneralExamination.setPallor("Pallor");
    phyGeneralExamination.setParkingPlaceID(1);
    phyGeneralExamination.setProcessed("Processed");
    phyGeneralExamination.setProviderServiceMapID(1);
    phyGeneralExamination.setQuickening("Quickening");
    phyGeneralExamination.setReservedForChange("Reserved For Change");
    phyGeneralExamination.setSyncedBy("Synced By");
    phyGeneralExamination.setSyncedDate(mock(Timestamp.class));
    phyGeneralExamination.setTypeOfDangerSign("Type Of Danger Sign");
    phyGeneralExamination.setTypeOfDangerSigns(new ArrayList<>());
    phyGeneralExamination.setTypeOfLymphadenopathy("Type Of Lymphadenopathy");
    phyGeneralExamination.setVanSerialNo(1L);
    phyGeneralExamination.setVehicalNo("Vehical No");
    phyGeneralExamination.setVisitCode(1L);

    PhyHeadToToeExamination phyHeadToToeExamination = new PhyHeadToToeExamination();
    phyHeadToToeExamination.setBenVisitID(1L);
    phyHeadToToeExamination.setBeneficiaryRegID(1L);
    phyHeadToToeExamination.setBreastAndNipples("Breast And Nipples");
    phyHeadToToeExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    phyHeadToToeExamination.setCreatedDate(mock(Timestamp.class));
    phyHeadToToeExamination.setDeleted(true);
    phyHeadToToeExamination.setEars("Ears");
    phyHeadToToeExamination.setEyes("Eyes");
    phyHeadToToeExamination.setHair("Hair");
    phyHeadToToeExamination.setHead("Head");
    phyHeadToToeExamination.setID(1L);
    phyHeadToToeExamination.setLastModDate(mock(Timestamp.class));
    phyHeadToToeExamination.setLowerLimbs("Lower Limbs");
    phyHeadToToeExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    phyHeadToToeExamination.setNails("Nails");
    phyHeadToToeExamination.setNose("Nose");
    phyHeadToToeExamination.setOralCavity("Oral Cavity");
    phyHeadToToeExamination.setParkingPlaceID(1);
    phyHeadToToeExamination.setProcessed("Processed");
    phyHeadToToeExamination.setProviderServiceMapID(1);
    phyHeadToToeExamination.setReservedForChange("Reserved For Change");
    phyHeadToToeExamination.setSkin("Skin");
    phyHeadToToeExamination.setSyncedBy("Synced By");
    phyHeadToToeExamination.setSyncedDate(mock(Timestamp.class));
    phyHeadToToeExamination.setThroat("Throat");
    phyHeadToToeExamination.setTrunk("Trunk");
    phyHeadToToeExamination.setUpperLimbs("Upper Limbs");
    phyHeadToToeExamination.setVanSerialNo(1L);
    phyHeadToToeExamination.setVehicalNo("Vehical No");
    phyHeadToToeExamination.setVisitCode(1L);

    SysCardiovascularExamination sysCardiovascularExamination = new SysCardiovascularExamination();
    sysCardiovascularExamination.setAdditionalHeartSounds("Additional Heart Sounds");
    sysCardiovascularExamination.setApexbeatLocation("Apexbeat Location");
    sysCardiovascularExamination.setApexbeatType("Apexbeat Type");
    sysCardiovascularExamination.setBenVisitID(1L);
    sysCardiovascularExamination.setBeneficiaryRegID(1L);
    sysCardiovascularExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysCardiovascularExamination.setCreatedDate(mock(Timestamp.class));
    sysCardiovascularExamination.setDeleted(true);
    sysCardiovascularExamination.setFirstHeartSound_S1("First Heart Sound S1");
    sysCardiovascularExamination.setID(1L);
    sysCardiovascularExamination.setJugularVenousPulse_JVP("Jugular Venous Pulse JVP");
    sysCardiovascularExamination.setLastModDate(mock(Timestamp.class));
    sysCardiovascularExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysCardiovascularExamination.setMurmurs("Murmurs");
    sysCardiovascularExamination.setParkingPlaceID(1);
    sysCardiovascularExamination.setPericardialRub("Pericardial Rub");
    sysCardiovascularExamination.setProcessed("Processed");
    sysCardiovascularExamination.setProviderServiceMapID(1);
    sysCardiovascularExamination.setReservedForChange("Reserved For Change");
    sysCardiovascularExamination.setSecondHeartSound_S2("Second Heart Sound S2");
    sysCardiovascularExamination.setSyncedBy("Synced By");
    sysCardiovascularExamination.setSyncedDate(mock(Timestamp.class));
    sysCardiovascularExamination.setVanSerialNo(1L);
    sysCardiovascularExamination.setVehicalNo("Vehical No");
    sysCardiovascularExamination.setVisitCode(1L);

    SysCentralNervousExamination sysCentralNervousExamination = new SysCentralNervousExamination();
    sysCentralNervousExamination.setAutonomicSystem("Autonomic System");
    sysCentralNervousExamination.setBenVisitID(1L);
    sysCentralNervousExamination.setBeneficiaryRegID(1L);
    sysCentralNervousExamination.setCerebellarSigns("Cerebellar Signs");
    sysCentralNervousExamination.setCranialNervesExamination("Cranial Nerves Examination");
    sysCentralNervousExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysCentralNervousExamination.setCreatedDate(mock(Timestamp.class));
    sysCentralNervousExamination.setDeleted(true);
    sysCentralNervousExamination.setHandedness("Handedness");
    sysCentralNervousExamination.setID(1L);
    sysCentralNervousExamination.setLastModDate(mock(Timestamp.class));
    sysCentralNervousExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysCentralNervousExamination.setMotorSystem("Motor System");
    sysCentralNervousExamination.setParkingPlaceID(1);
    sysCentralNervousExamination.setProcessed("Processed");
    sysCentralNervousExamination.setProviderServiceMapID(1);
    sysCentralNervousExamination.setReservedForChange("Reserved For Change");
    sysCentralNervousExamination.setSensorySystem("Sensory System");
    sysCentralNervousExamination.setSignsOfMeningealIrritation("Signs Of Meningeal Irritation");
    sysCentralNervousExamination.setSkull("Skull");
    sysCentralNervousExamination.setSyncedBy("Synced By");
    sysCentralNervousExamination.setSyncedDate(mock(Timestamp.class));
    sysCentralNervousExamination.setVanSerialNo(1L);
    sysCentralNervousExamination.setVehicalNo("Vehical No");
    sysCentralNervousExamination.setVisitCode(1L);

    SysGastrointestinalExamination sysGastrointestinalExamination = new SysGastrointestinalExamination();
    sysGastrointestinalExamination.setAnalRegion("us-east-2");
    sysGastrointestinalExamination.setAuscultation("Auscultation");
    sysGastrointestinalExamination.setBenVisitID(1L);
    sysGastrointestinalExamination.setBeneficiaryRegID(1L);
    sysGastrointestinalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysGastrointestinalExamination.setCreatedDate(mock(Timestamp.class));
    sysGastrointestinalExamination.setDeleted(true);
    sysGastrointestinalExamination.setID(1L);
    sysGastrointestinalExamination.setInspection("Inspection");
    sysGastrointestinalExamination.setLastModDate(mock(Timestamp.class));
    sysGastrointestinalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysGastrointestinalExamination.setPalpation("Palpation");
    sysGastrointestinalExamination.setPalpation_AbdomenTexture("Palpation Abdomen Texture");
    sysGastrointestinalExamination.setPalpation_Liver("Palpation Liver");
    sysGastrointestinalExamination.setPalpation_LocationOfTenderness("Palpation Location Of Tenderness");
    sysGastrointestinalExamination.setPalpation_Spleen("Palpation Spleen");
    sysGastrointestinalExamination.setPalpation_Tenderness("Palpation Tenderness");
    sysGastrointestinalExamination.setParkingPlaceID(1);
    sysGastrointestinalExamination.setPercussion("Percussion");
    sysGastrointestinalExamination.setProcessed("Processed");
    sysGastrointestinalExamination.setProviderServiceMapID(1);
    sysGastrointestinalExamination.setReservedForChange("Reserved For Change");
    sysGastrointestinalExamination.setSyncedBy("Synced By");
    sysGastrointestinalExamination.setSyncedDate(mock(Timestamp.class));
    sysGastrointestinalExamination.setVanSerialNo(1L);
    sysGastrointestinalExamination.setVehicalNo("Vehical No");
    sysGastrointestinalExamination.setVisitCode(1L);

    SysGenitourinarySystemExamination sysGenitourinarySystemExamination = new SysGenitourinarySystemExamination();
    sysGenitourinarySystemExamination.setBenVisitID(1L);
    sysGenitourinarySystemExamination.setBeneficiaryRegID(1L);
    sysGenitourinarySystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysGenitourinarySystemExamination.setCreatedDate(mock(Timestamp.class));
    sysGenitourinarySystemExamination.setDeleted(true);
    sysGenitourinarySystemExamination.setExternalGenitalia("External Genitalia");
    sysGenitourinarySystemExamination.setID(1L);
    sysGenitourinarySystemExamination.setLastModDate(mock(Timestamp.class));
    sysGenitourinarySystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysGenitourinarySystemExamination.setParkingPlaceID(1);
    sysGenitourinarySystemExamination.setProcessed("Processed");
    sysGenitourinarySystemExamination.setProviderServiceMapID(1);
    sysGenitourinarySystemExamination.setRenalAngle("Renal Angle");
    sysGenitourinarySystemExamination.setReservedForChange("Reserved For Change");
    sysGenitourinarySystemExamination.setSuprapubicRegion("us-east-2");
    sysGenitourinarySystemExamination.setSyncedBy("Synced By");
    sysGenitourinarySystemExamination.setSyncedDate(mock(Timestamp.class));
    sysGenitourinarySystemExamination.setVanSerialNo(1L);
    sysGenitourinarySystemExamination.setVehicalNo("Vehical No");
    sysGenitourinarySystemExamination.setVisitCode(1L);

    SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = new SysMusculoskeletalSystemExamination();
    sysMusculoskeletalSystemExamination.setBenVisitID(1L);
    sysMusculoskeletalSystemExamination.setBeneficiaryRegID(1L);
    sysMusculoskeletalSystemExamination.setChestWall("Chest Wall");
    sysMusculoskeletalSystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysMusculoskeletalSystemExamination.setCreatedDate(mock(Timestamp.class));
    sysMusculoskeletalSystemExamination.setDeleted(true);
    sysMusculoskeletalSystemExamination.setID(1L);
    sysMusculoskeletalSystemExamination.setJoint_Abnormality("Joint Abnormality");
    sysMusculoskeletalSystemExamination.setJoint_Laterality("Joint Laterality");
    sysMusculoskeletalSystemExamination.setJoint_TypeOfJoint("Joint Type Of Joint");
    sysMusculoskeletalSystemExamination.setLastModDate(mock(Timestamp.class));
    sysMusculoskeletalSystemExamination.setLowerLimb_Abnormality("Lower Limb Abnormality");
    sysMusculoskeletalSystemExamination.setLowerLimb_Laterality("Lower Limb Laterality");
    sysMusculoskeletalSystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysMusculoskeletalSystemExamination.setParkingPlaceID(1);
    sysMusculoskeletalSystemExamination.setProcessed("Processed");
    sysMusculoskeletalSystemExamination.setProviderServiceMapID(1);
    sysMusculoskeletalSystemExamination.setReservedForChange("Reserved For Change");
    sysMusculoskeletalSystemExamination.setSpine("Spine");
    sysMusculoskeletalSystemExamination.setSyncedBy("Synced By");
    sysMusculoskeletalSystemExamination.setSyncedDate(mock(Timestamp.class));
    sysMusculoskeletalSystemExamination.setUpperLimb_Abnormality("Upper Limb Abnormality");
    sysMusculoskeletalSystemExamination.setUpperLimb_Laterality("Upper Limb Laterality");
    sysMusculoskeletalSystemExamination.setVanSerialNo(1L);
    sysMusculoskeletalSystemExamination.setVehicalNo("Vehical No");
    sysMusculoskeletalSystemExamination.setVisitCode(1L);

    SysRespiratoryExamination sysRespiratoryExamination = new SysRespiratoryExamination();
    sysRespiratoryExamination.setAuscultation("Auscultation");
    sysRespiratoryExamination.setAuscultation_BreathSounds("Auscultation Breath Sounds");
    sysRespiratoryExamination.setAuscultation_ConductedSounds("Auscultation Conducted Sounds");
    sysRespiratoryExamination.setAuscultation_Crepitations("Auscultation Crepitations");
    sysRespiratoryExamination.setAuscultation_PleuralRub("Auscultation Pleural Rub");
    sysRespiratoryExamination.setAuscultation_Stridor("Auscultation Stridor");
    sysRespiratoryExamination.setAuscultation_Wheezing("Auscultation Wheezing");
    sysRespiratoryExamination.setBenVisitID(1L);
    sysRespiratoryExamination.setBeneficiaryRegID(1L);
    sysRespiratoryExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    sysRespiratoryExamination.setCreatedDate(mock(Timestamp.class));
    sysRespiratoryExamination.setDeleted(true);
    sysRespiratoryExamination.setID(1L);
    sysRespiratoryExamination.setInspection("Inspection");
    sysRespiratoryExamination.setLastModDate(mock(Timestamp.class));
    sysRespiratoryExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    sysRespiratoryExamination.setPalpation("Palpation");
    sysRespiratoryExamination.setParkingPlaceID(1);
    sysRespiratoryExamination.setPercussion("Percussion");
    sysRespiratoryExamination.setProcessed("Processed");
    sysRespiratoryExamination.setProviderServiceMapID(1);
    sysRespiratoryExamination.setReservedForChange("Reserved For Change");
    sysRespiratoryExamination.setSignsOfRespiratoryDistress("Signs Of Respiratory Distress");
    sysRespiratoryExamination.setSyncedBy("Synced By");
    sysRespiratoryExamination.setSyncedDate(mock(Timestamp.class));
    sysRespiratoryExamination.setTrachea("Trachea");
    sysRespiratoryExamination.setVanSerialNo(1L);
    sysRespiratoryExamination.setVehicalNo("Vehical No");
    sysRespiratoryExamination.setVisitCode(1L);
    when(commonNurseServiceImpl.getGeneralExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(phyGeneralExamination);
    when(commonNurseServiceImpl.getHeadToToeExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(phyHeadToToeExamination);
    when(commonNurseServiceImpl.getCardiovascularExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysCardiovascularExamination);
    when(commonNurseServiceImpl.getSysCentralNervousExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysCentralNervousExamination);
    when(commonNurseServiceImpl.getSysGastrointestinalExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysGastrointestinalExamination);
    when(commonNurseServiceImpl.getGenitourinaryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysGenitourinarySystemExamination);
    when(commonNurseServiceImpl.getMusculoskeletalExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysMusculoskeletalSystemExamination);
    when(commonNurseServiceImpl.getRespiratoryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(sysRespiratoryExamination);

    // Act
    pNCServiceImpl.getPNCExaminationDetailsData(1L, 1L);
  }

  @Test
  void testUpdateBenHistoryDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenHistoryDetails(new JsonObject()));
    assertEquals(1, pNCServiceImpl.updateBenHistoryDetails(null));
  }

  @Test
  void testUpdateBenHistoryDetails2() throws Exception {
    // Arrange
    JsonObject historyOBJ = new JsonObject();
    historyOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenHistoryDetails(historyOBJ));
  }

  @Test
  void testUpdateBenHistoryDetails3() throws Exception {
    // Arrange
    JsonObject historyOBJ = new JsonObject();
    historyOBJ.addProperty("pastHistory", (String) null);

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenHistoryDetails(historyOBJ));
  }

  @Test
  void testUpdateBenHistoryDetails4() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateBenPastHistoryDetails(Mockito.<BenMedHistory>any())).thenReturn(1);

    JsonObject historyOBJ = new JsonObject();
    historyOBJ.add("pastHistory", new JsonObject());

    // Act
    int actualUpdateBenHistoryDetailsResult = pNCServiceImpl.updateBenHistoryDetails(historyOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateBenPastHistoryDetails(Mockito.<BenMedHistory>any());
    assertEquals(1, actualUpdateBenHistoryDetailsResult);
  }

  @Test
  void testUpdateBenHistoryDetails5() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateBenPastHistoryDetails(Mockito.<BenMedHistory>any())).thenReturn(0);

    JsonObject historyOBJ = new JsonObject();
    historyOBJ.add("pastHistory", new JsonObject());

    // Act
    int actualUpdateBenHistoryDetailsResult = pNCServiceImpl.updateBenHistoryDetails(historyOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateBenPastHistoryDetails(Mockito.<BenMedHistory>any());
    assertEquals(0, actualUpdateBenHistoryDetailsResult);
  }
  @Test
  void testUpdateBenVitalDetails() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(new JsonObject());

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails2() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(0);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(new JsonObject());

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(0, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails3() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(0);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(new JsonObject());

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(0, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails4() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenVitalDetails(null));
  }

  @Test
  void testUpdateBenVitalDetails5() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.add("Property", new JsonArray(3));

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(vitalDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails6() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.addProperty("Property", "42");

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(vitalDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails7() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    JsonObject vitalDetailsOBJ = new JsonObject();
    Integer value = Integer.valueOf(1);
    vitalDetailsOBJ.addProperty("Property", value);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(vitalDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
    assertSame(value, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails8() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.addProperty("Property", true);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(vitalDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenVitalDetails9() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
            .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.updateBenVitalDetails(new JsonObject()));
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
  }

  @Test
  void testUpdateBenVitalDetails10() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any())).thenReturn(1);
    when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any())).thenReturn(1);

    JsonObject vitalDetailsOBJ = new JsonObject();
    vitalDetailsOBJ.add("Property", null);

    // Act
    int actualUpdateBenVitalDetailsResult = pNCServiceImpl.updateBenVitalDetails(vitalDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updateANCAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
    verify(commonNurseServiceImpl).updateANCPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
    assertEquals(1, actualUpdateBenVitalDetailsResult);
  }

  @Test
  void testUpdateBenExaminationDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenExaminationDetails(new JsonObject()));
    assertEquals(1, pNCServiceImpl.updateBenExaminationDetails(null));
  }

  @Test
  void testUpdateBenExaminationDetails2() throws Exception {
    // Arrange
    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenExaminationDetails(examinationDetailsOBJ));
  }
  @Test
  void testUpdateBenExaminationDetails3() throws Exception {
    // Arrange
    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.addProperty("generalExamination", (String) null);

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenExaminationDetails(examinationDetailsOBJ));
  }

  @Test
  void testUpdateBenExaminationDetails4() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updatePhyGeneralExamination(Mockito.<PhyGeneralExamination>any())).thenReturn(1);

    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.add("generalExamination", new JsonObject());

    // Act
    int actualUpdateBenExaminationDetailsResult = pNCServiceImpl.updateBenExaminationDetails(examinationDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updatePhyGeneralExamination(Mockito.<PhyGeneralExamination>any());
    assertEquals(1, actualUpdateBenExaminationDetailsResult);
  }

  @Test
  void testUpdateBenExaminationDetails5() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updatePhyGeneralExamination(Mockito.<PhyGeneralExamination>any())).thenReturn(0);

    JsonObject examinationDetailsOBJ = new JsonObject();
    examinationDetailsOBJ.add("generalExamination", new JsonObject());

    // Act
    int actualUpdateBenExaminationDetailsResult = pNCServiceImpl.updateBenExaminationDetails(examinationDetailsOBJ);

    // Assert
    verify(commonNurseServiceImpl).updatePhyGeneralExamination(Mockito.<PhyGeneralExamination>any());
    assertEquals(0, actualUpdateBenExaminationDetailsResult);
  }

  @Test
  void testUpdateBenPNCDetails() throws Exception {
    // Arrange, Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenPNCDetails(new JsonObject()));
    assertEquals(1, pNCServiceImpl.updateBenPNCDetails(null));
  }

  @Test
  void testUpdateBenPNCDetails2() throws Exception {
    // Arrange
    JsonObject pncDetailsOBJ = new JsonObject();
    pncDetailsOBJ.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenPNCDetails(pncDetailsOBJ));
  }

  @Test
  void testUpdateBenPNCDetails3() throws Exception {
    // Arrange
    JsonObject pncDetailsOBJ = new JsonObject();
    pncDetailsOBJ.add("42", new JsonArray(3));

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenPNCDetails(pncDetailsOBJ));
  }

  @Test
  void testUpdateBenPNCDetails4() throws Exception {
    // Arrange
    JsonObject pncDetailsOBJ = new JsonObject();
    pncDetailsOBJ.addProperty("PNCDetails", (String) null);

    // Act and Assert
    assertEquals(1, pNCServiceImpl.updateBenPNCDetails(pncDetailsOBJ));
  }

  @Test
  @Disabled("TODO: Complete this test")
  void testGetBenPNCNurseData() {

    // Arrange and Act
    (new PNCServiceImpl()).getBenPNCNurseData(1L, 1L);
  }

  /**
   * Method under test:
   * {@link PNCServiceImpl#getBenCaseRecordFromDoctorPNC(Long, Long)}
   */
  @Test
  void testGetBenCaseRecordFromDoctorPNC() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Findings Details");
    when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Investigation Details");
    when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Prescribed Drugs");
    when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Referral Details");
    when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
            .thenReturn(new HashMap<>());
    when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Last 3 Archived Test Visit List");
    when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(new ArrayList<>());
    when(pNCDoctorServiceImpl.getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Pnc Diagnosis Details");

    // Act
    String actualBenCaseRecordFromDoctorPNC = pNCServiceImpl.getBenCaseRecordFromDoctorPNC(1L, 1L);

    // Assert
    verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("pnc"));
    verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
    verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
    verify(pNCDoctorServiceImpl).getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
            + " diagnosis=Pnc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
            + " 3 Archived Test Visit List, GraphData={}}", actualBenCaseRecordFromDoctorPNC);
  }

  @Test
  void testGetBenCaseRecordFromDoctorPNC2() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Findings Details");
    when(pNCDoctorServiceImpl.getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenThrow(new RuntimeException("findings"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.getBenCaseRecordFromDoctorPNC(1L, 1L));
    verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(pNCDoctorServiceImpl).getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
  }

  @Test
  void testGetBenCaseRecordFromDoctorPNC3() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Findings Details");
    when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Investigation Details");
    when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Prescribed Drugs");
    when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Referral Details");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("findings", "42");
    when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
            .thenReturn(stringObjectMap);
    when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Last 3 Archived Test Visit List");
    when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(new ArrayList<>());
    when(pNCDoctorServiceImpl.getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Pnc Diagnosis Details");

    // Act
    String actualBenCaseRecordFromDoctorPNC = pNCServiceImpl.getBenCaseRecordFromDoctorPNC(1L, 1L);

    // Assert
    verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("pnc"));
    verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
    verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
    verify(pNCDoctorServiceImpl).getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
            + " diagnosis=Pnc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
            + " 3 Archived Test Visit List, GraphData={\"findings\":\"42\"}}", actualBenCaseRecordFromDoctorPNC);
  }

  @Test
  void testGetBenCaseRecordFromDoctorPNC4() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Findings Details");
    when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Investigation Details");
    when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Prescribed Drugs");
    when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Referral Details");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("diagnosis", "42");
    stringObjectMap.put("findings", "42");
    when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
            .thenReturn(stringObjectMap);
    when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Last 3 Archived Test Visit List");
    when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn(new ArrayList<>());
    when(pNCDoctorServiceImpl.getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
            .thenReturn("Pnc Diagnosis Details");

    // Act
    String actualBenCaseRecordFromDoctorPNC = pNCServiceImpl.getBenCaseRecordFromDoctorPNC(1L, 1L);

    // Assert
    verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
    verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("pnc"));
    verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
    verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
    verify(pNCDoctorServiceImpl).getPNCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
                    + " diagnosis=Pnc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
                    + " 3 Archived Test Visit List, GraphData={\"findings\":\"42\",\"diagnosis\":\"42\"}}",
            actualBenCaseRecordFromDoctorPNC);
  }

  @Test
  void testUpdatePNCDoctorData() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
            Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any())).thenReturn(1);
    when(commonNurseServiceImpl.updatePrescription(Mockito.<PrescriptionDetail>any())).thenReturn(1);

    // Act
    Long actualUpdatePNCDoctorDataResult = pNCServiceImpl.updatePNCDoctorData(new JsonObject(), "JaneDoe");

    // Assert
    verify(commonDoctorServiceImpl).updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
            Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any());
    verify(commonNurseServiceImpl).updatePrescription(Mockito.<PrescriptionDetail>any());
    assertEquals(1L, actualUpdatePNCDoctorDataResult.longValue());
  }

  @Test
  void testUpdatePNCDoctorData2() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updatePrescription(Mockito.<PrescriptionDetail>any()))
            .thenThrow(new RuntimeException("investigation"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.updatePNCDoctorData(new JsonObject(), "JaneDoe"));
    verify(commonNurseServiceImpl).updatePrescription(Mockito.<PrescriptionDetail>any());
  }

  @Test
  void testUpdatePNCDoctorData3() throws Exception {
    // Arrange
    when(commonDoctorServiceImpl.updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
            Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any())).thenReturn(0);
    when(commonNurseServiceImpl.updatePrescription(Mockito.<PrescriptionDetail>any())).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.updatePNCDoctorData(new JsonObject(), "JaneDoe"));
    verify(commonDoctorServiceImpl).updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
            Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any());
    verify(commonNurseServiceImpl).updatePrescription(Mockito.<PrescriptionDetail>any());
  }

  @Test
  void testUpdatePNCDoctorData4() throws Exception {
    // Arrange, Act and Assert
    assertNull(pNCServiceImpl.updatePNCDoctorData(null, "JaneDoe"));
  }

  @Test
  void testUpdatePNCDoctorData5() throws Exception {
    // Arrange
    when(commonNurseServiceImpl.updatePrescription(Mockito.<PrescriptionDetail>any()))
            .thenThrow(new RuntimeException("investigation"));

    JsonObject requestOBJ = new JsonObject();
    requestOBJ.add("prescription", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pNCServiceImpl.updatePNCDoctorData(requestOBJ, "JaneDoe"));
    verify(commonNurseServiceImpl).updatePrescription(Mockito.<PrescriptionDetail>any());
  }

  @Test
  void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     PNCServiceImpl.beneficiaryFlowStatusRepo
    //     PNCServiceImpl.commonBenStatusFlowServiceImpl
    //     PNCServiceImpl.commonDoctorServiceImpl
    //     PNCServiceImpl.commonNurseServiceImpl
    //     PNCServiceImpl.labTechnicianServiceImpl
    //     PNCServiceImpl.pncDoctorServiceImpl
    //     PNCServiceImpl.pncNurseServiceImpl
    //     PNCServiceImpl.teleConsultationServiceImpl

    // Arrange
    PNCServiceImpl pncServiceImpl = new PNCServiceImpl();

    // Act
    pncServiceImpl.setCommonBenStatusFlowServiceImpl(new CommonBenStatusFlowServiceImpl());
    pncServiceImpl.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
    pncServiceImpl.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
    pncServiceImpl.setLabTechnicianServiceImpl(new LabTechnicianServiceImpl());
    pncServiceImpl.setPncDoctorServiceImpl(new PNCDoctorServiceImpl());
    pncServiceImpl.setPncNurseServiceImpl(new PNCNurseServiceImpl());
  }
}
