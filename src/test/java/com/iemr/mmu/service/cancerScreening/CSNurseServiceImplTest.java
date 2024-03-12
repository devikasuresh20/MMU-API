package com.iemr.mmu.service.cancerScreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenObstetricCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerDietHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

@ExtendWith(MockitoExtension.class)
class CSNurseServiceImplTest {
  @Mock
  private BenCancerVitalDetailRepo benCancerVitalDetailRepo;

  @Mock
  private BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo;

  @Mock
  private BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo;

  @Mock
  private BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo;

  @Mock
  private BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo;

  @Mock
  private BenVisitDetailRepo benVisitDetailRepo;

 @InjectMocks
  private CSNurseServiceImpl cSNurseServiceImpl;

  @Mock
  private CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo;

  @Mock
  private CancerBreastExaminationRepo cancerBreastExaminationRepo;

  @Mock
  private CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo;

  @Mock
  private CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo;

  @Mock
  private CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo;

  @Mock
  private CancerOralExaminationRepo cancerOralExaminationRepo;

  @Mock
  private CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl.saveBenFamilyCancerHistory(new ArrayList<>());

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(1, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory2() {
    // Arrange
    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(benFamilyCancerHistoryList);

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl.saveBenFamilyCancerHistory(new ArrayList<>());

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(0, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory3() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl
        .saveBenFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(1, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory4() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    BenFamilyCancerHistory benFamilyCancerHistory2 = new BenFamilyCancerHistory();
    benFamilyCancerHistory2.setBenVisitID(2L);
    benFamilyCancerHistory2.setBeneficiaryRegID(2L);
    benFamilyCancerHistory2.setCancerDiseaseType("");
    benFamilyCancerHistory2.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory2.setCreatedBy("Created By");
    benFamilyCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setDeleted(false);
    benFamilyCancerHistory2.setFamilyMember("");
    benFamilyCancerHistory2.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory2.setID(2L);
    benFamilyCancerHistory2.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setModifiedBy("Modified By");
    benFamilyCancerHistory2.setParkingPlaceID(2);
    benFamilyCancerHistory2.setProcessed("");
    benFamilyCancerHistory2.setProviderServiceMapID(2);
    benFamilyCancerHistory2.setReservedForChange("");
    benFamilyCancerHistory2.setSnomedCode("");
    benFamilyCancerHistory2.setSnomedTerm("");
    benFamilyCancerHistory2.setSyncedBy("");
    benFamilyCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setVanID(2);
    benFamilyCancerHistory2.setVanSerialNo(0L);
    benFamilyCancerHistory2.setVehicalNo("");
    benFamilyCancerHistory2.setVisitCode(0L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory2);
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl
        .saveBenFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(1, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory5() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> familyMemberList = new ArrayList<>();
    familyMemberList.add("foo");

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(familyMemberList);
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl
        .saveBenFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(0, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenFamilyCancerHistory(List)}
   */
  @Test
  void testSaveBenFamilyCancerHistory6() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> familyMemberList = new ArrayList<>();
    familyMemberList.add("");
    familyMemberList.add("foo");

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(familyMemberList);
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualSaveBenFamilyCancerHistoryResult = cSNurseServiceImpl
        .saveBenFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(0, actualSaveBenFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenPersonalCancerHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testSaveBenPersonalCancerHistory() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);
    when(benPersonalCancerHistoryRepo.save(Mockito.<BenPersonalCancerHistory>any()))
        .thenReturn(benPersonalCancerHistory);

    BenPersonalCancerHistory benPersonalCancerHistory2 = new BenPersonalCancerHistory();
    benPersonalCancerHistory2.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory2.setBenVisitID(1L);
    benPersonalCancerHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setDeleted(true);
    benPersonalCancerHistory2.setDurationOfBetelQuid(1);
    benPersonalCancerHistory2.setEndAge_year(3);
    benPersonalCancerHistory2.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory2.setID(1L);
    benPersonalCancerHistory2.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory2.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory2.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory2.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory2.setParkingPlaceID(1);
    benPersonalCancerHistory2.setProcessed("Processed");
    benPersonalCancerHistory2.setProviderServiceMapID(1);
    benPersonalCancerHistory2.setQuantityPerDay(1);
    benPersonalCancerHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory2.setSsAlcoholUsed(true);
    benPersonalCancerHistory2.setStartAge_year(1);
    benPersonalCancerHistory2.setSyncedBy("Synced By");
    benPersonalCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory2.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory2.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory2.setVanID(1);
    benPersonalCancerHistory2.setVanSerialNo(1L);
    benPersonalCancerHistory2.setVehicalNo("Vehical No");
    benPersonalCancerHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenPersonalCancerHistoryResult = cSNurseServiceImpl
        .saveBenPersonalCancerHistory(benPersonalCancerHistory2);

    // Assert
    verify(benPersonalCancerHistoryRepo).save(Mockito.<BenPersonalCancerHistory>any());
    assertEquals("", benPersonalCancerHistory2.getTypeOfTobaccoProduct());
    assertEquals(1L, actualSaveBenPersonalCancerHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenPersonalCancerHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testSaveBenPersonalCancerHistory2() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getID()).thenReturn(1L);
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);
    when(benPersonalCancerHistoryRepo.save(Mockito.<BenPersonalCancerHistory>any()))
        .thenReturn(benPersonalCancerHistory);

    BenPersonalCancerHistory benPersonalCancerHistory2 = new BenPersonalCancerHistory();
    benPersonalCancerHistory2.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory2.setBenVisitID(1L);
    benPersonalCancerHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setDeleted(true);
    benPersonalCancerHistory2.setDurationOfBetelQuid(1);
    benPersonalCancerHistory2.setEndAge_year(3);
    benPersonalCancerHistory2.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory2.setID(1L);
    benPersonalCancerHistory2.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory2.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory2.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory2.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory2.setParkingPlaceID(1);
    benPersonalCancerHistory2.setProcessed("Processed");
    benPersonalCancerHistory2.setProviderServiceMapID(1);
    benPersonalCancerHistory2.setQuantityPerDay(1);
    benPersonalCancerHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory2.setSsAlcoholUsed(true);
    benPersonalCancerHistory2.setStartAge_year(1);
    benPersonalCancerHistory2.setSyncedBy("Synced By");
    benPersonalCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory2.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory2.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory2.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory2.setVanID(1);
    benPersonalCancerHistory2.setVanSerialNo(1L);
    benPersonalCancerHistory2.setVehicalNo("Vehical No");
    benPersonalCancerHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenPersonalCancerHistoryResult = cSNurseServiceImpl
        .saveBenPersonalCancerHistory(benPersonalCancerHistory2);

    // Assert
    verify(benPersonalCancerHistory).getID();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory).setTypeOfTobaccoProduct(eq("Type Of Tobacco Product"));
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).save(Mockito.<BenPersonalCancerHistory>any());
    assertEquals("", benPersonalCancerHistory2.getTypeOfTobaccoProduct());
    assertEquals(1L, actualSaveBenPersonalCancerHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalHistoryOBJ(BenPersonalCancerHistory)}
   */
  @Test
  void testGetBenPersonalHistoryOBJ() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerHistory actualBenPersonalHistoryOBJ = cSNurseServiceImpl
        .getBenPersonalHistoryOBJ(benPersonalCancerHistory);

    // Assert
    assertEquals("", actualBenPersonalHistoryOBJ.getTypeOfTobaccoProduct());
    assertSame(benPersonalCancerHistory, actualBenPersonalHistoryOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalHistoryOBJ(BenPersonalCancerHistory)}
   */
  @Test
  void testGetBenPersonalHistoryOBJ2() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getTypeOfTobaccoProductList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerHistory actualBenPersonalHistoryOBJ = cSNurseServiceImpl
        .getBenPersonalHistoryOBJ(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistory).getTypeOfTobaccoProductList();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory, atLeast(1)).setTypeOfTobaccoProduct(Mockito.<String>any());
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    assertSame(benPersonalCancerHistory, actualBenPersonalHistoryOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalHistoryOBJ(BenPersonalCancerHistory)}
   */
  @Test
  void testGetBenPersonalHistoryOBJ3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getTypeOfTobaccoProductList()).thenReturn(stringList);
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerHistory actualBenPersonalHistoryOBJ = cSNurseServiceImpl
        .getBenPersonalHistoryOBJ(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistory).getTypeOfTobaccoProductList();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory, atLeast(1)).setTypeOfTobaccoProduct(Mockito.<String>any());
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    assertSame(benPersonalCancerHistory, actualBenPersonalHistoryOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testSaveBenPersonalCancerDietHistory() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.save(Mockito.<BenPersonalCancerDietHistory>any()))
        .thenReturn(benPersonalCancerDietHistory);

    BenPersonalCancerDietHistory benPersonalCancerDietHistory2 = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory2.setBenVisitID(1L);
    benPersonalCancerDietHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setDeleted(true);
    benPersonalCancerDietHistory2.setDietType("Diet Type");
    benPersonalCancerDietHistory2.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory2.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory2.setID(1L);
    benPersonalCancerDietHistory2.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory2.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory2.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory2.setParkingPlaceID(1);
    benPersonalCancerDietHistory2.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory2.setProcessed("Processed");
    benPersonalCancerDietHistory2.setProviderServiceMapID(1);
    benPersonalCancerDietHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory2.setSsRadiationExposure(true);
    benPersonalCancerDietHistory2.setSyncedBy("Synced By");
    benPersonalCancerDietHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory2.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory2.setVanID(1);
    benPersonalCancerDietHistory2.setVanSerialNo(1L);
    benPersonalCancerDietHistory2.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory2.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory2.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory2);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).save(Mockito.<BenPersonalCancerDietHistory>any());
    assertEquals("", benPersonalCancerDietHistory2.getTypeOfOilConsumed());
    assertEquals(1L, actualSaveBenPersonalCancerDietHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testSaveBenPersonalCancerDietHistory2() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getID()).thenReturn(1L);
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.save(Mockito.<BenPersonalCancerDietHistory>any()))
        .thenReturn(benPersonalCancerDietHistory);

    BenPersonalCancerDietHistory benPersonalCancerDietHistory2 = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory2.setBenVisitID(1L);
    benPersonalCancerDietHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setDeleted(true);
    benPersonalCancerDietHistory2.setDietType("Diet Type");
    benPersonalCancerDietHistory2.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory2.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory2.setID(1L);
    benPersonalCancerDietHistory2.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory2.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory2.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory2.setParkingPlaceID(1);
    benPersonalCancerDietHistory2.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory2.setProcessed("Processed");
    benPersonalCancerDietHistory2.setProviderServiceMapID(1);
    benPersonalCancerDietHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory2.setSsRadiationExposure(true);
    benPersonalCancerDietHistory2.setSyncedBy("Synced By");
    benPersonalCancerDietHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory2.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory2.setVanID(1);
    benPersonalCancerDietHistory2.setVanSerialNo(1L);
    benPersonalCancerDietHistory2.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory2.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory2.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory2);

    // Assert
    verify(benPersonalCancerDietHistory).getID();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumed(eq("Type Of Oil Consumed"));
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).save(Mockito.<BenPersonalCancerDietHistory>any());
    assertEquals("", benPersonalCancerDietHistory2.getTypeOfOilConsumed());
    assertEquals(1L, actualSaveBenPersonalCancerDietHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testSaveBenPersonalCancerDietHistory3() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getID()).thenReturn(1L);
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.save(Mockito.<BenPersonalCancerDietHistory>any()))
        .thenReturn(benPersonalCancerDietHistory);
    BenPersonalCancerDietHistory benPersonalCancerDietHistory2 = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory2.getTypeOfOilConsumedList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerDietHistory2).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory2).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory2).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory2).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory2).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory2).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory2).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory2).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory2).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory2).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory2).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory2).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory2).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory2).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory2.setBenVisitID(1L);
    benPersonalCancerDietHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setDeleted(true);
    benPersonalCancerDietHistory2.setDietType("Diet Type");
    benPersonalCancerDietHistory2.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory2.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory2.setID(1L);
    benPersonalCancerDietHistory2.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory2.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory2.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory2.setParkingPlaceID(1);
    benPersonalCancerDietHistory2.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory2.setProcessed("Processed");
    benPersonalCancerDietHistory2.setProviderServiceMapID(1);
    benPersonalCancerDietHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory2.setSsRadiationExposure(true);
    benPersonalCancerDietHistory2.setSyncedBy("Synced By");
    benPersonalCancerDietHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory2.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory2.setVanID(1);
    benPersonalCancerDietHistory2.setVanSerialNo(1L);
    benPersonalCancerDietHistory2.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory2.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory2.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory2);

    // Assert
    verify(benPersonalCancerDietHistory).getID();
    verify(benPersonalCancerDietHistory2).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory2).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory2).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory2).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory2).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory2).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory2).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory2).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory2).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory2).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory2).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory2).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory2).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory2).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory2).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory2).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory2).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory2).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory2).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory2, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumed(eq("Type Of Oil Consumed"));
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory2).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory2).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory2).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory2).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory2).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).save(Mockito.<BenPersonalCancerDietHistory>any());
    assertEquals(1L, actualSaveBenPersonalCancerDietHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietOBJ(BenPersonalCancerDietHistory)}
   */
  @Test
  void testGetBenPersonalCancerDietOBJ() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerDietHistory actualBenPersonalCancerDietOBJ = cSNurseServiceImpl
        .getBenPersonalCancerDietOBJ(benPersonalCancerDietHistory);

    // Assert
    assertEquals("", actualBenPersonalCancerDietOBJ.getTypeOfOilConsumed());
    assertSame(benPersonalCancerDietHistory, actualBenPersonalCancerDietOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietOBJ(BenPersonalCancerDietHistory)}
   */
  @Test
  void testGetBenPersonalCancerDietOBJ2() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getTypeOfOilConsumedList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerDietHistory actualBenPersonalCancerDietOBJ = cSNurseServiceImpl
        .getBenPersonalCancerDietOBJ(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    assertSame(benPersonalCancerDietHistory, actualBenPersonalCancerDietOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietOBJ(BenPersonalCancerDietHistory)}
   */
  @Test
  void testGetBenPersonalCancerDietOBJ3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getTypeOfOilConsumedList()).thenReturn(stringList);
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    BenPersonalCancerDietHistory actualBenPersonalCancerDietOBJ = cSNurseServiceImpl
        .getBenPersonalCancerDietOBJ(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    assertSame(benPersonalCancerDietHistory, actualBenPersonalCancerDietOBJ);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenObstetricCancerHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testSaveBenObstetricCancerHistory() {
    // Arrange
    BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);
    when(benObstetricCancerHistoryRepo.save(Mockito.<BenObstetricCancerHistory>any()))
        .thenReturn(benObstetricCancerHistory);

    BenObstetricCancerHistory benObstetricCancerHistory2 = new BenObstetricCancerHistory();
    benObstetricCancerHistory2.setBenVisitID(1L);
    benObstetricCancerHistory2.setBeneficiaryRegID(1L);
    benObstetricCancerHistory2.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setDeleted(true);
    benObstetricCancerHistory2.setID(1L);
    benObstetricCancerHistory2.setIsAbortion("Is Abortion");
    benObstetricCancerHistory2.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory2.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory2.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory2.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory2.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory2.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory2.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory2.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory2.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setMenarche_Age(1);
    benObstetricCancerHistory2.setMenopauseAge(1);
    benObstetricCancerHistory2.setMenstrualCycleLength(3);
    benObstetricCancerHistory2.setMenstrualFlowDuration(1);
    benObstetricCancerHistory2.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory2.setNoOfLivingChild(1);
    benObstetricCancerHistory2.setParkingPlaceID(1);
    benObstetricCancerHistory2.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory2.setPregnant_No("Pregnant No");
    benObstetricCancerHistory2.setProcessed("Processed");
    benObstetricCancerHistory2.setProviderServiceMapID(1);
    benObstetricCancerHistory2.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory2.setSyncedBy("Synced By");
    benObstetricCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setVanID(1);
    benObstetricCancerHistory2.setVanSerialNo(1L);
    benObstetricCancerHistory2.setVehicalNo("Vehical No");
    benObstetricCancerHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenObstetricCancerHistoryResult = cSNurseServiceImpl
        .saveBenObstetricCancerHistory(benObstetricCancerHistory2);

    // Assert
    verify(benObstetricCancerHistoryRepo).save(Mockito.<BenObstetricCancerHistory>any());
    assertEquals(1L, actualSaveBenObstetricCancerHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenObstetricCancerHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testSaveBenObstetricCancerHistory2() {
    // Arrange
    BenObstetricCancerHistory benObstetricCancerHistory = mock(BenObstetricCancerHistory.class);
    when(benObstetricCancerHistory.getID()).thenReturn(1L);
    doNothing().when(benObstetricCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benObstetricCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benObstetricCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setIsAbortion(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsDysmenorrhea(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsFoulSmellingDischarge(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsHormoneReplacementTherapy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsInterMenstrualBleeding(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsMenstrualCycleRegular(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsOralContraceptiveUsed(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsPostMenopauseBleeding(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsUrinePregTest(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setMenarche_Age(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenopauseAge(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualCycleLength(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualFlowDuration(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualFlowType(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setNoOfLivingChild(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setPregnancyStatus(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setPregnant_No(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setVisitCode(Mockito.<Long>any());
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);
    when(benObstetricCancerHistoryRepo.save(Mockito.<BenObstetricCancerHistory>any()))
        .thenReturn(benObstetricCancerHistory);

    BenObstetricCancerHistory benObstetricCancerHistory2 = new BenObstetricCancerHistory();
    benObstetricCancerHistory2.setBenVisitID(1L);
    benObstetricCancerHistory2.setBeneficiaryRegID(1L);
    benObstetricCancerHistory2.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setDeleted(true);
    benObstetricCancerHistory2.setID(1L);
    benObstetricCancerHistory2.setIsAbortion("Is Abortion");
    benObstetricCancerHistory2.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory2.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory2.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory2.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory2.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory2.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory2.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory2.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory2.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setMenarche_Age(1);
    benObstetricCancerHistory2.setMenopauseAge(1);
    benObstetricCancerHistory2.setMenstrualCycleLength(3);
    benObstetricCancerHistory2.setMenstrualFlowDuration(1);
    benObstetricCancerHistory2.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory2.setNoOfLivingChild(1);
    benObstetricCancerHistory2.setParkingPlaceID(1);
    benObstetricCancerHistory2.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory2.setPregnant_No("Pregnant No");
    benObstetricCancerHistory2.setProcessed("Processed");
    benObstetricCancerHistory2.setProviderServiceMapID(1);
    benObstetricCancerHistory2.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory2.setSyncedBy("Synced By");
    benObstetricCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory2.setVanID(1);
    benObstetricCancerHistory2.setVanSerialNo(1L);
    benObstetricCancerHistory2.setVehicalNo("Vehical No");
    benObstetricCancerHistory2.setVisitCode(1L);

    // Act
    Long actualSaveBenObstetricCancerHistoryResult = cSNurseServiceImpl
        .saveBenObstetricCancerHistory(benObstetricCancerHistory2);

    // Assert
    verify(benObstetricCancerHistory).getID();
    verify(benObstetricCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benObstetricCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benObstetricCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benObstetricCancerHistory).setID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setIsAbortion(eq("Is Abortion"));
    verify(benObstetricCancerHistory).setIsDysmenorrhea(eq("Is Dysmenorrhea"));
    verify(benObstetricCancerHistory).setIsFoulSmellingDischarge(eq("Is Foul Smelling Discharge"));
    verify(benObstetricCancerHistory).setIsHormoneReplacementTherapy(eq("Is Hormone Replacement Therapy"));
    verify(benObstetricCancerHistory).setIsInterMenstrualBleeding(eq("Is Inter Menstrual Bleeding"));
    verify(benObstetricCancerHistory).setIsMenstrualCycleRegular(eq("Is Menstrual Cycle Regular"));
    verify(benObstetricCancerHistory).setIsOralContraceptiveUsed(eq("Is Oral Contraceptive Used"));
    verify(benObstetricCancerHistory).setIsPostMenopauseBleeding(eq("Is Post Menopause Bleeding"));
    verify(benObstetricCancerHistory).setIsUrinePregTest(eq("Is Urine Preg Test"));
    verify(benObstetricCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setMenarche_Age(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenopauseAge(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualCycleLength(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualFlowDuration(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualFlowType(eq("Menstrual Flow Type"));
    verify(benObstetricCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benObstetricCancerHistory).setNoOfLivingChild(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setPregnancyStatus(eq("Pregnancy Status"));
    verify(benObstetricCancerHistory).setPregnant_No(eq("Pregnant No"));
    verify(benObstetricCancerHistory).setProcessed(eq("Processed"));
    verify(benObstetricCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benObstetricCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benObstetricCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benObstetricCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benObstetricCancerHistoryRepo).save(Mockito.<BenObstetricCancerHistory>any());
    assertEquals(1L, actualSaveBenObstetricCancerHistoryResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenVitalDetail(BenCancerVitalDetail)}
   */
  @Test
  void testSaveBenVitalDetail() {
    // Arrange
    BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");
    when(benCancerVitalDetailRepo.save(Mockito.<BenCancerVitalDetail>any())).thenReturn(benCancerVitalDetail);

    BenCancerVitalDetail benCancerVitalDetail2 = new BenCancerVitalDetail();
    benCancerVitalDetail2.setBenVisitID(1L);
    benCancerVitalDetail2.setBeneficiaryRegID(1L);
    benCancerVitalDetail2.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail2.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setDeleted(true);
    benCancerVitalDetail2.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setHbA1C((short) 1);
    benCancerVitalDetail2.setHeight_cm(10.0d);
    benCancerVitalDetail2.setHemoglobin(10.0d);
    benCancerVitalDetail2.setID(1L);
    benCancerVitalDetail2.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail2.setParkingPlaceID(1);
    benCancerVitalDetail2.setProcessed("Processed");
    benCancerVitalDetail2.setProviderServiceMapID(1);
    benCancerVitalDetail2.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail2.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail2.setReservedForChange("Reserved For Change");
    benCancerVitalDetail2.setSyncedBy("Synced By");
    benCancerVitalDetail2.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setVanID(1);
    benCancerVitalDetail2.setVanSerialNo(1L);
    benCancerVitalDetail2.setVehicalNo("Vehical No");
    benCancerVitalDetail2.setVisitCode(1L);
    benCancerVitalDetail2.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail2.setWeight_Kg(10.0d);
    benCancerVitalDetail2.setsPO2("S PO2");

    // Act
    Long actualSaveBenVitalDetailResult = cSNurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail2);

    // Assert
    verify(benCancerVitalDetailRepo).save(Mockito.<BenCancerVitalDetail>any());
    assertEquals(1L, actualSaveBenVitalDetailResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveBenVitalDetail(BenCancerVitalDetail)}
   */
  @Test
  void testSaveBenVitalDetail2() {
    // Arrange
    BenCancerVitalDetail benCancerVitalDetail = mock(BenCancerVitalDetail.class);
    when(benCancerVitalDetail.getID()).thenReturn(1L);
    doNothing().when(benCancerVitalDetail).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benCancerVitalDetail).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benCancerVitalDetail).setBloodGlucose_2HrPostPrandial(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setBloodGlucose_Fasting(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setBloodGlucose_Random(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setCreatedBy(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benCancerVitalDetail).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benCancerVitalDetail).setDiastolicBP_1stReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setDiastolicBP_2ndReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setDiastolicBP_3rdReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setHbA1C(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setHeight_cm(Mockito.<Double>any());
    doNothing().when(benCancerVitalDetail).setHemoglobin(Mockito.<Double>any());
    doNothing().when(benCancerVitalDetail).setID(Mockito.<Long>any());
    doNothing().when(benCancerVitalDetail).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benCancerVitalDetail).setModifiedBy(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benCancerVitalDetail).setProcessed(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benCancerVitalDetail).setRbsTestRemarks(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setRbsTestResult(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setReservedForChange(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setSyncedBy(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benCancerVitalDetail).setSystolicBP_1stReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setSystolicBP_2ndReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setSystolicBP_3rdReading(Mockito.<Short>any());
    doNothing().when(benCancerVitalDetail).setVanID(Mockito.<Integer>any());
    doNothing().when(benCancerVitalDetail).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benCancerVitalDetail).setVehicalNo(Mockito.<String>any());
    doNothing().when(benCancerVitalDetail).setVisitCode(Mockito.<Long>any());
    doNothing().when(benCancerVitalDetail).setWaistCircumference_cm(Mockito.<Double>any());
    doNothing().when(benCancerVitalDetail).setWeight_Kg(Mockito.<Double>any());
    doNothing().when(benCancerVitalDetail).setsPO2(Mockito.<String>any());
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");
    when(benCancerVitalDetailRepo.save(Mockito.<BenCancerVitalDetail>any())).thenReturn(benCancerVitalDetail);

    BenCancerVitalDetail benCancerVitalDetail2 = new BenCancerVitalDetail();
    benCancerVitalDetail2.setBenVisitID(1L);
    benCancerVitalDetail2.setBeneficiaryRegID(1L);
    benCancerVitalDetail2.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail2.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setDeleted(true);
    benCancerVitalDetail2.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setHbA1C((short) 1);
    benCancerVitalDetail2.setHeight_cm(10.0d);
    benCancerVitalDetail2.setHemoglobin(10.0d);
    benCancerVitalDetail2.setID(1L);
    benCancerVitalDetail2.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail2.setParkingPlaceID(1);
    benCancerVitalDetail2.setProcessed("Processed");
    benCancerVitalDetail2.setProviderServiceMapID(1);
    benCancerVitalDetail2.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail2.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail2.setReservedForChange("Reserved For Change");
    benCancerVitalDetail2.setSyncedBy("Synced By");
    benCancerVitalDetail2.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setVanID(1);
    benCancerVitalDetail2.setVanSerialNo(1L);
    benCancerVitalDetail2.setVehicalNo("Vehical No");
    benCancerVitalDetail2.setVisitCode(1L);
    benCancerVitalDetail2.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail2.setWeight_Kg(10.0d);
    benCancerVitalDetail2.setsPO2("S PO2");

    // Act
    Long actualSaveBenVitalDetailResult = cSNurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail2);

    // Assert
    verify(benCancerVitalDetail).getID();
    verify(benCancerVitalDetail).setBenVisitID(Mockito.<Long>any());
    verify(benCancerVitalDetail).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benCancerVitalDetail).setBloodGlucose_2HrPostPrandial(Mockito.<Short>any());
    verify(benCancerVitalDetail).setBloodGlucose_Fasting(Mockito.<Short>any());
    verify(benCancerVitalDetail).setBloodGlucose_Random(Mockito.<Short>any());
    verify(benCancerVitalDetail).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benCancerVitalDetail).setCreatedDate(Mockito.<Timestamp>any());
    verify(benCancerVitalDetail).setDeleted(Mockito.<Boolean>any());
    verify(benCancerVitalDetail).setDiastolicBP_1stReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setDiastolicBP_2ndReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setDiastolicBP_3rdReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setHbA1C(Mockito.<Short>any());
    verify(benCancerVitalDetail).setHeight_cm(Mockito.<Double>any());
    verify(benCancerVitalDetail).setHemoglobin(Mockito.<Double>any());
    verify(benCancerVitalDetail).setID(Mockito.<Long>any());
    verify(benCancerVitalDetail).setLastModDate(Mockito.<Timestamp>any());
    verify(benCancerVitalDetail).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benCancerVitalDetail).setParkingPlaceID(Mockito.<Integer>any());
    verify(benCancerVitalDetail).setProcessed(eq("Processed"));
    verify(benCancerVitalDetail).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benCancerVitalDetail).setRbsTestRemarks(eq("Rbs Test Remarks"));
    verify(benCancerVitalDetail).setRbsTestResult(eq("Rbs Test Result"));
    verify(benCancerVitalDetail).setReservedForChange(eq("Reserved For Change"));
    verify(benCancerVitalDetail).setSyncedBy(eq("Synced By"));
    verify(benCancerVitalDetail).setSyncedDate(Mockito.<Timestamp>any());
    verify(benCancerVitalDetail).setSystolicBP_1stReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setSystolicBP_2ndReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setSystolicBP_3rdReading(Mockito.<Short>any());
    verify(benCancerVitalDetail).setVanID(Mockito.<Integer>any());
    verify(benCancerVitalDetail).setVanSerialNo(Mockito.<Long>any());
    verify(benCancerVitalDetail).setVehicalNo(eq("Vehical No"));
    verify(benCancerVitalDetail).setVisitCode(Mockito.<Long>any());
    verify(benCancerVitalDetail).setWaistCircumference_cm(Mockito.<Double>any());
    verify(benCancerVitalDetail).setWeight_Kg(Mockito.<Double>any());
    verify(benCancerVitalDetail).setsPO2(eq("S PO2"));
    verify(benCancerVitalDetailRepo).save(Mockito.<BenCancerVitalDetail>any());
    assertEquals(1L, actualSaveBenVitalDetailResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory() {
    // Arrange, Act and Assert
    assertEquals(0, cSNurseServiceImpl.updateBeneficiaryFamilyCancerHistory(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory2() {
    // Arrange
    when(benFamilyCancerHistoryRepo.getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualUpdateBeneficiaryFamilyCancerHistoryResult = cSNurseServiceImpl
        .updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals(1, actualUpdateBeneficiaryFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory3() {
    // Arrange
    ArrayList<Object[]> objectArrayList = new ArrayList<>();
    objectArrayList.add(new Object[]{"42"});
    when(benFamilyCancerHistoryRepo.getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(objectArrayList);

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualUpdateBeneficiaryFamilyCancerHistoryResult = cSNurseServiceImpl
        .updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals(0, actualUpdateBeneficiaryFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory4() {
    // Arrange
    when(benFamilyCancerHistoryRepo.getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    BenFamilyCancerHistory benFamilyCancerHistory2 = new BenFamilyCancerHistory();
    benFamilyCancerHistory2.setBenVisitID(2L);
    benFamilyCancerHistory2.setBeneficiaryRegID(2L);
    benFamilyCancerHistory2.setCancerDiseaseType("42");
    benFamilyCancerHistory2.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory2.setCreatedBy("Created By");
    benFamilyCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setDeleted(false);
    benFamilyCancerHistory2.setFamilyMember("42");
    benFamilyCancerHistory2.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory2.setID(2L);
    benFamilyCancerHistory2.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setModifiedBy("Modified By");
    benFamilyCancerHistory2.setParkingPlaceID(2);
    benFamilyCancerHistory2.setProcessed("42");
    benFamilyCancerHistory2.setProviderServiceMapID(2);
    benFamilyCancerHistory2.setReservedForChange("42");
    benFamilyCancerHistory2.setSnomedCode("42");
    benFamilyCancerHistory2.setSnomedTerm("42");
    benFamilyCancerHistory2.setSyncedBy("42");
    benFamilyCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setVanID(2);
    benFamilyCancerHistory2.setVanSerialNo(0L);
    benFamilyCancerHistory2.setVehicalNo("42");
    benFamilyCancerHistory2.setVisitCode(0L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory2);
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualUpdateBeneficiaryFamilyCancerHistoryResult = cSNurseServiceImpl
        .updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals(1, actualUpdateBeneficiaryFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory5() {
    // Arrange
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(new ArrayList<>());
    when(benFamilyCancerHistoryRepo.getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> familyMemberList = new ArrayList<>();
    familyMemberList.add("foo");

    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(familyMemberList);
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);

    // Act
    int actualUpdateBeneficiaryFamilyCancerHistoryResult = cSNurseServiceImpl
        .updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);

    // Assert
    verify(benFamilyCancerHistoryRepo).getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(0, actualUpdateBeneficiaryFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBeneficiaryFamilyCancerHistory(List)}
   */
  @Test
  void testUpdateBeneficiaryFamilyCancerHistory6() {
    // Arrange
    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);
    when(benFamilyCancerHistoryRepo.saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any()))
        .thenReturn(benFamilyCancerHistoryList);
    when(benFamilyCancerHistoryRepo.getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> familyMemberList = new ArrayList<>();
    familyMemberList.add("foo");

    BenFamilyCancerHistory benFamilyCancerHistory2 = new BenFamilyCancerHistory();
    benFamilyCancerHistory2.setBenVisitID(1L);
    benFamilyCancerHistory2.setBeneficiaryRegID(1L);
    benFamilyCancerHistory2.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory2.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory2.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setDeleted(true);
    benFamilyCancerHistory2.setFamilyMember("Family Member");
    benFamilyCancerHistory2.setFamilyMemberList(familyMemberList);
    benFamilyCancerHistory2.setID(1L);
    benFamilyCancerHistory2.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory2.setParkingPlaceID(1);
    benFamilyCancerHistory2.setProcessed("Processed");
    benFamilyCancerHistory2.setProviderServiceMapID(1);
    benFamilyCancerHistory2.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory2.setSnomedCode("Snomed Code");
    benFamilyCancerHistory2.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory2.setSyncedBy("Synced By");
    benFamilyCancerHistory2.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory2.setVanID(1);
    benFamilyCancerHistory2.setVanSerialNo(1L);
    benFamilyCancerHistory2.setVehicalNo("Vehical No");
    benFamilyCancerHistory2.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList2 = new ArrayList<>();
    benFamilyCancerHistoryList2.add(benFamilyCancerHistory2);

    // Act
    int actualUpdateBeneficiaryFamilyCancerHistoryResult = cSNurseServiceImpl
        .updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList2);

    // Assert
    verify(benFamilyCancerHistoryRepo).getFamilyCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benFamilyCancerHistoryRepo).saveAll(Mockito.<Iterable<BenFamilyCancerHistory>>any());
    assertEquals(1, actualUpdateBeneficiaryFamilyCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenObstetricCancerHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testUpdateBenObstetricCancerHistory() {
    // Arrange
    when(benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(benObstetricCancerHistoryRepo.getObstetricCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Obstetric Cancer History Status");

    BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenObstetricCancerHistoryResult = cSNurseServiceImpl
        .updateBenObstetricCancerHistory(benObstetricCancerHistory);

    // Assert
    verify(benObstetricCancerHistoryRepo).getObstetricCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benObstetricCancerHistoryRepo).updateBenObstetricCancerHistory(Mockito.<Integer>any(),
        eq("Pregnancy Status"), Mockito.<Boolean>any(), eq("Pregnant No"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Menstrual Flow Type"),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(), eq("U"));
    assertEquals("U", benObstetricCancerHistory.getProcessed());
    assertEquals(1, actualUpdateBenObstetricCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenObstetricCancerHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testUpdateBenObstetricCancerHistory2() {
    // Arrange
    when(benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(benObstetricCancerHistoryRepo.getObstetricCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("N");

    BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenObstetricCancerHistoryResult = cSNurseServiceImpl
        .updateBenObstetricCancerHistory(benObstetricCancerHistory);

    // Assert
    verify(benObstetricCancerHistoryRepo).getObstetricCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benObstetricCancerHistoryRepo).updateBenObstetricCancerHistory(Mockito.<Integer>any(),
        eq("Pregnancy Status"), Mockito.<Boolean>any(), eq("Pregnant No"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Menstrual Flow Type"),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(), eq("N"));
    assertEquals("N", benObstetricCancerHistory.getProcessed());
    assertEquals(1, actualUpdateBenObstetricCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenObstetricHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testUpdateBenObstetricHistory() {
    // Arrange
    when(benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenObstetricHistoryResult = cSNurseServiceImpl.updateBenObstetricHistory(benObstetricCancerHistory);

    // Assert
    verify(benObstetricCancerHistoryRepo).updateBenObstetricCancerHistory(Mockito.<Integer>any(),
        eq("Pregnancy Status"), Mockito.<Boolean>any(), eq("Pregnant No"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Menstrual Flow Type"),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals(1, actualUpdateBenObstetricHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenObstetricHistory(BenObstetricCancerHistory)}
   */
  @Test
  void testUpdateBenObstetricHistory2() {
    // Arrange
    when(benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    BenObstetricCancerHistory benObstetricCancerHistory = mock(BenObstetricCancerHistory.class);
    when(benObstetricCancerHistory.getIsAbortion()).thenReturn(true);
    when(benObstetricCancerHistory.getIsDysmenorrhea()).thenReturn(true);
    when(benObstetricCancerHistory.getIsFoulSmellingDischarge()).thenReturn(true);
    when(benObstetricCancerHistory.getIsHormoneReplacementTherapy()).thenReturn(true);
    when(benObstetricCancerHistory.getIsInterMenstrualBleeding()).thenReturn(true);
    when(benObstetricCancerHistory.getIsMenstrualCycleRegular()).thenReturn(true);
    when(benObstetricCancerHistory.getIsOralContraceptiveUsed()).thenReturn(true);
    when(benObstetricCancerHistory.getIsPostMenopauseBleeding()).thenReturn(true);
    when(benObstetricCancerHistory.getIsUrinePregTest()).thenReturn(true);
    when(benObstetricCancerHistory.getMenarche_Age()).thenReturn(1);
    when(benObstetricCancerHistory.getMenopauseAge()).thenReturn(1);
    when(benObstetricCancerHistory.getMenstrualCycleLength()).thenReturn(3);
    when(benObstetricCancerHistory.getMenstrualFlowDuration()).thenReturn(1);
    when(benObstetricCancerHistory.getNoOfLivingChild()).thenReturn(1);
    when(benObstetricCancerHistory.getProviderServiceMapID()).thenReturn(1);
    when(benObstetricCancerHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benObstetricCancerHistory.getVisitCode()).thenReturn(1L);
    when(benObstetricCancerHistory.getMenstrualFlowType()).thenReturn("Menstrual Flow Type");
    when(benObstetricCancerHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benObstetricCancerHistory.getPregnancyStatus()).thenReturn("Pregnancy Status");
    when(benObstetricCancerHistory.getPregnant_No()).thenReturn("Pregnant No");
    when(benObstetricCancerHistory.getProcessed()).thenReturn("Processed");
    doNothing().when(benObstetricCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benObstetricCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benObstetricCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setIsAbortion(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsDysmenorrhea(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsFoulSmellingDischarge(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsHormoneReplacementTherapy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsInterMenstrualBleeding(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsMenstrualCycleRegular(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsOralContraceptiveUsed(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsPostMenopauseBleeding(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setIsUrinePregTest(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setMenarche_Age(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenopauseAge(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualCycleLength(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualFlowDuration(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setMenstrualFlowType(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setNoOfLivingChild(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setPregnancyStatus(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setPregnant_No(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benObstetricCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benObstetricCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benObstetricCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benObstetricCancerHistory).setVisitCode(Mockito.<Long>any());
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenObstetricHistoryResult = cSNurseServiceImpl.updateBenObstetricHistory(benObstetricCancerHistory);

    // Assert
    verify(benObstetricCancerHistory).getBeneficiaryRegID();
    verify(benObstetricCancerHistory).getIsAbortion();
    verify(benObstetricCancerHistory).getIsDysmenorrhea();
    verify(benObstetricCancerHistory).getIsFoulSmellingDischarge();
    verify(benObstetricCancerHistory).getIsHormoneReplacementTherapy();
    verify(benObstetricCancerHistory).getIsInterMenstrualBleeding();
    verify(benObstetricCancerHistory).getIsMenstrualCycleRegular();
    verify(benObstetricCancerHistory).getIsOralContraceptiveUsed();
    verify(benObstetricCancerHistory).getIsPostMenopauseBleeding();
    verify(benObstetricCancerHistory).getIsUrinePregTest();
    verify(benObstetricCancerHistory).getMenarche_Age();
    verify(benObstetricCancerHistory).getMenopauseAge();
    verify(benObstetricCancerHistory).getMenstrualCycleLength();
    verify(benObstetricCancerHistory).getMenstrualFlowDuration();
    verify(benObstetricCancerHistory).getMenstrualFlowType();
    verify(benObstetricCancerHistory).getModifiedBy();
    verify(benObstetricCancerHistory).getNoOfLivingChild();
    verify(benObstetricCancerHistory).getPregnancyStatus();
    verify(benObstetricCancerHistory).getPregnant_No();
    verify(benObstetricCancerHistory).getProcessed();
    verify(benObstetricCancerHistory).getProviderServiceMapID();
    verify(benObstetricCancerHistory).getVisitCode();
    verify(benObstetricCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benObstetricCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benObstetricCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benObstetricCancerHistory).setID(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setIsAbortion(eq("Is Abortion"));
    verify(benObstetricCancerHistory).setIsDysmenorrhea(eq("Is Dysmenorrhea"));
    verify(benObstetricCancerHistory).setIsFoulSmellingDischarge(eq("Is Foul Smelling Discharge"));
    verify(benObstetricCancerHistory).setIsHormoneReplacementTherapy(eq("Is Hormone Replacement Therapy"));
    verify(benObstetricCancerHistory).setIsInterMenstrualBleeding(eq("Is Inter Menstrual Bleeding"));
    verify(benObstetricCancerHistory).setIsMenstrualCycleRegular(eq("Is Menstrual Cycle Regular"));
    verify(benObstetricCancerHistory).setIsOralContraceptiveUsed(eq("Is Oral Contraceptive Used"));
    verify(benObstetricCancerHistory).setIsPostMenopauseBleeding(eq("Is Post Menopause Bleeding"));
    verify(benObstetricCancerHistory).setIsUrinePregTest(eq("Is Urine Preg Test"));
    verify(benObstetricCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setMenarche_Age(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenopauseAge(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualCycleLength(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualFlowDuration(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setMenstrualFlowType(eq("Menstrual Flow Type"));
    verify(benObstetricCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benObstetricCancerHistory).setNoOfLivingChild(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setPregnancyStatus(eq("Pregnancy Status"));
    verify(benObstetricCancerHistory).setPregnant_No(eq("Pregnant No"));
    verify(benObstetricCancerHistory).setProcessed(eq("Processed"));
    verify(benObstetricCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benObstetricCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benObstetricCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benObstetricCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benObstetricCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benObstetricCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benObstetricCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benObstetricCancerHistoryRepo).updateBenObstetricCancerHistory(Mockito.<Integer>any(),
        eq("Pregnancy Status"), Mockito.<Boolean>any(), eq("Pregnant No"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Menstrual Flow Type"),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals(1, actualUpdateBenObstetricHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalCancerHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testUpdateBenPersonalCancerHistory() {
    // Arrange
    when(benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(benPersonalCancerHistoryRepo.getPersonalCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Personal Cancer History Status");

    BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalCancerHistoryResult = cSNurseServiceImpl
        .updateBenPersonalCancerHistory(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistoryRepo).getPersonalCancerHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).updateBenPersonalCancerHistory(Mockito.<Integer>any(), eq("Tobacco Use"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), eq(""), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), eq("Alcohol Use"),
        Mockito.<Boolean>any(), eq("Frequency Of Alcohol Used"), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(),
        Mockito.<Long>any(), eq("U"));
    assertEquals("", benPersonalCancerHistory.getTypeOfTobaccoProduct());
    assertEquals("U", benPersonalCancerHistory.getProcessed());
    assertEquals(1, actualUpdateBenPersonalCancerHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testUpdateBenPersonalHistory() {
    // Arrange
    when(benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalHistoryResult = cSNurseServiceImpl.updateBenPersonalHistory(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistoryRepo).updateBenPersonalCancerHistory(Mockito.<Integer>any(), eq("Tobacco Use"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), eq(""), Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(), eq("Alcohol Use"),
        Mockito.<Boolean>any(), eq("Frequency Of Alcohol Used"), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(),
        Mockito.<Long>any(), eq("Processed"));
    assertEquals("", benPersonalCancerHistory.getTypeOfTobaccoProduct());
    assertEquals(1, actualUpdateBenPersonalHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testUpdateBenPersonalHistory2() {
    // Arrange
    when(benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getIsBetelNutChewing()).thenReturn(true);
    when(benPersonalCancerHistory.getIsCigaretteExposure()).thenReturn(true);
    when(benPersonalCancerHistory.getIsFilteredCigaerette()).thenReturn(true);
    when(benPersonalCancerHistory.getSsAlcoholUsed()).thenReturn(true);
    when(benPersonalCancerHistory.getDurationOfBetelQuid()).thenReturn(1);
    when(benPersonalCancerHistory.getEndAge_year()).thenReturn(3);
    when(benPersonalCancerHistory.getProviderServiceMapID()).thenReturn(1);
    when(benPersonalCancerHistory.getQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerHistory.getStartAge_year()).thenReturn(1);
    when(benPersonalCancerHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benPersonalCancerHistory.getVisitCode()).thenReturn(1L);
    when(benPersonalCancerHistory.getAlcoholUse()).thenReturn("Alcohol Use");
    when(benPersonalCancerHistory.getFrequencyOfAlcoholUsed()).thenReturn("Frequency Of Alcohol Used");
    when(benPersonalCancerHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benPersonalCancerHistory.getProcessed()).thenReturn("Processed");
    when(benPersonalCancerHistory.getTobaccoUse()).thenReturn("Tobacco Use");
    when(benPersonalCancerHistory.getTypeOfTobaccoProduct()).thenReturn("Type Of Tobacco Product");
    when(benPersonalCancerHistory.getTypeOfTobaccoProductList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalHistoryResult = cSNurseServiceImpl.updateBenPersonalHistory(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistory).getAlcoholUse();
    verify(benPersonalCancerHistory).getBeneficiaryRegID();
    verify(benPersonalCancerHistory).getDurationOfBetelQuid();
    verify(benPersonalCancerHistory).getEndAge_year();
    verify(benPersonalCancerHistory).getFrequencyOfAlcoholUsed();
    verify(benPersonalCancerHistory).getIsBetelNutChewing();
    verify(benPersonalCancerHistory).getIsCigaretteExposure();
    verify(benPersonalCancerHistory).getIsFilteredCigaerette();
    verify(benPersonalCancerHistory).getModifiedBy();
    verify(benPersonalCancerHistory).getProcessed();
    verify(benPersonalCancerHistory).getProviderServiceMapID();
    verify(benPersonalCancerHistory).getQuantityPerDay();
    verify(benPersonalCancerHistory).getSsAlcoholUsed();
    verify(benPersonalCancerHistory).getStartAge_year();
    verify(benPersonalCancerHistory).getTobaccoUse();
    verify(benPersonalCancerHistory).getTypeOfTobaccoProduct();
    verify(benPersonalCancerHistory).getTypeOfTobaccoProductList();
    verify(benPersonalCancerHistory).getVisitCode();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory, atLeast(1)).setTypeOfTobaccoProduct(Mockito.<String>any());
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).updateBenPersonalCancerHistory(Mockito.<Integer>any(), eq("Tobacco Use"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Type Of Tobacco Product"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        eq("Alcohol Use"), Mockito.<Boolean>any(), eq("Frequency Of Alcohol Used"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateBenPersonalHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalHistory(BenPersonalCancerHistory)}
   */
  @Test
  void testUpdateBenPersonalHistory3() {
    // Arrange
    when(benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(Mockito.<Integer>any(), Mockito.<String>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getIsBetelNutChewing()).thenReturn(true);
    when(benPersonalCancerHistory.getIsCigaretteExposure()).thenReturn(true);
    when(benPersonalCancerHistory.getIsFilteredCigaerette()).thenReturn(true);
    when(benPersonalCancerHistory.getSsAlcoholUsed()).thenReturn(true);
    when(benPersonalCancerHistory.getDurationOfBetelQuid()).thenReturn(1);
    when(benPersonalCancerHistory.getEndAge_year()).thenReturn(3);
    when(benPersonalCancerHistory.getProviderServiceMapID()).thenReturn(1);
    when(benPersonalCancerHistory.getQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerHistory.getStartAge_year()).thenReturn(1);
    when(benPersonalCancerHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benPersonalCancerHistory.getVisitCode()).thenReturn(1L);
    when(benPersonalCancerHistory.getAlcoholUse()).thenReturn("Alcohol Use");
    when(benPersonalCancerHistory.getFrequencyOfAlcoholUsed()).thenReturn("Frequency Of Alcohol Used");
    when(benPersonalCancerHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benPersonalCancerHistory.getProcessed()).thenReturn("Processed");
    when(benPersonalCancerHistory.getTobaccoUse()).thenReturn("Tobacco Use");
    when(benPersonalCancerHistory.getTypeOfTobaccoProduct()).thenReturn("Type Of Tobacco Product");
    when(benPersonalCancerHistory.getTypeOfTobaccoProductList()).thenReturn(stringList);
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalHistoryResult = cSNurseServiceImpl.updateBenPersonalHistory(benPersonalCancerHistory);

    // Assert
    verify(benPersonalCancerHistory).getAlcoholUse();
    verify(benPersonalCancerHistory).getBeneficiaryRegID();
    verify(benPersonalCancerHistory).getDurationOfBetelQuid();
    verify(benPersonalCancerHistory).getEndAge_year();
    verify(benPersonalCancerHistory).getFrequencyOfAlcoholUsed();
    verify(benPersonalCancerHistory).getIsBetelNutChewing();
    verify(benPersonalCancerHistory).getIsCigaretteExposure();
    verify(benPersonalCancerHistory).getIsFilteredCigaerette();
    verify(benPersonalCancerHistory).getModifiedBy();
    verify(benPersonalCancerHistory).getProcessed();
    verify(benPersonalCancerHistory).getProviderServiceMapID();
    verify(benPersonalCancerHistory).getQuantityPerDay();
    verify(benPersonalCancerHistory).getSsAlcoholUsed();
    verify(benPersonalCancerHistory).getStartAge_year();
    verify(benPersonalCancerHistory).getTobaccoUse();
    verify(benPersonalCancerHistory).getTypeOfTobaccoProduct();
    verify(benPersonalCancerHistory).getTypeOfTobaccoProductList();
    verify(benPersonalCancerHistory).getVisitCode();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory, atLeast(1)).setTypeOfTobaccoProduct(Mockito.<String>any());
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).updateBenPersonalCancerHistory(Mockito.<Integer>any(), eq("Tobacco Use"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), eq("Type Of Tobacco Product"), Mockito.<Integer>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Integer>any(),
        eq("Alcohol Use"), Mockito.<Boolean>any(), eq("Frequency Of Alcohol Used"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateBenPersonalHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalCancerDietHistory() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);
    when(benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Personal Cancer Diet History Status");

    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).getPersonalCancerDietHistoryStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq(""), eq("Physical Activity Type"), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(), eq("U"));
    assertEquals("", benPersonalCancerDietHistory.getTypeOfOilConsumed());
    assertEquals("U", benPersonalCancerDietHistory.getProcessed());
    assertEquals(1, actualUpdateBenPersonalCancerDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalCancerDietHistory2() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);
    when(benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("N");

    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).getPersonalCancerDietHistoryStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq(""), eq("Physical Activity Type"), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(), eq("N"));
    assertEquals("", benPersonalCancerDietHistory.getTypeOfOilConsumed());
    assertEquals("N", benPersonalCancerDietHistory.getProcessed());
    assertEquals(1, actualUpdateBenPersonalCancerDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalCancerDietHistory3() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.save(Mockito.<BenPersonalCancerDietHistory>any()))
        .thenReturn(benPersonalCancerDietHistory);
    when(benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(null);

    BenPersonalCancerDietHistory benPersonalCancerDietHistory2 = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory2.setBenVisitID(1L);
    benPersonalCancerDietHistory2.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory2.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory2.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setDeleted(true);
    benPersonalCancerDietHistory2.setDietType("Diet Type");
    benPersonalCancerDietHistory2.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory2.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory2.setID(1L);
    benPersonalCancerDietHistory2.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory2.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory2.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory2.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory2.setParkingPlaceID(1);
    benPersonalCancerDietHistory2.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory2.setProcessed("Processed");
    benPersonalCancerDietHistory2.setProviderServiceMapID(1);
    benPersonalCancerDietHistory2.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory2.setSsRadiationExposure(true);
    benPersonalCancerDietHistory2.setSyncedBy("Synced By");
    benPersonalCancerDietHistory2.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory2.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory2.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory2.setVanID(1);
    benPersonalCancerDietHistory2.setVanSerialNo(1L);
    benPersonalCancerDietHistory2.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory2.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory2.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory2.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory2);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).getPersonalCancerDietHistoryStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).save(Mockito.<BenPersonalCancerDietHistory>any());
    assertEquals("", benPersonalCancerDietHistory2.getTypeOfOilConsumed());
    assertEquals("Jan 1, 2020 9:00am GMT+0100", benPersonalCancerDietHistory2.getCreatedBy());
    assertEquals("N", benPersonalCancerDietHistory2.getProcessed());
    assertEquals(1, actualUpdateBenPersonalCancerDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalCancerDietHistory4() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);
    when(benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Personal Cancer Diet History Status");
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getIsThyroidDisorder()).thenReturn(true);
    when(benPersonalCancerDietHistory.getSsRadiationExposure()).thenReturn(true);
    when(benPersonalCancerDietHistory.getFruitConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getFruitQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal()).thenReturn(1);
    when(benPersonalCancerDietHistory.getProviderServiceMapID()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getVisitCode()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getDietType()).thenReturn("Diet Type");
    when(benPersonalCancerDietHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benPersonalCancerDietHistory.getPhysicalActivityType()).thenReturn("Physical Activity Type");
    when(benPersonalCancerDietHistory.getProcessed()).thenReturn("Processed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumed()).thenReturn("Type Of Oil Consumed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumedList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalCancerDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistory, atLeast(1)).getBeneficiaryRegID();
    verify(benPersonalCancerDietHistory).getDietType();
    verify(benPersonalCancerDietHistory).getFruitConsumptionDays();
    verify(benPersonalCancerDietHistory).getFruitQuantityPerDay();
    verify(benPersonalCancerDietHistory).getIntakeOfOutsidePreparedMeal();
    verify(benPersonalCancerDietHistory).getIsThyroidDisorder();
    verify(benPersonalCancerDietHistory).getModifiedBy();
    verify(benPersonalCancerDietHistory).getPhysicalActivityType();
    verify(benPersonalCancerDietHistory).getProcessed();
    verify(benPersonalCancerDietHistory).getProviderServiceMapID();
    verify(benPersonalCancerDietHistory).getSsRadiationExposure();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumed();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).getVegetableConsumptionDays();
    verify(benPersonalCancerDietHistory).getVegetableQuantityPerDay();
    verify(benPersonalCancerDietHistory, atLeast(1)).getVisitCode();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory, atLeast(1)).setProcessed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).getPersonalCancerDietHistoryStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq("Type Of Oil Consumed"), eq("Physical Activity Type"), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals(1, actualUpdateBenPersonalCancerDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalDietHistory() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);

    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq(""), eq("Physical Activity Type"), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(), eq("Processed"));
    assertEquals("", benPersonalCancerDietHistory.getTypeOfOilConsumed());
    assertEquals(1, actualUpdateBenPersonalDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalDietHistory2() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getIsThyroidDisorder()).thenReturn(true);
    when(benPersonalCancerDietHistory.getSsRadiationExposure()).thenReturn(true);
    when(benPersonalCancerDietHistory.getFruitConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getFruitQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal()).thenReturn(1);
    when(benPersonalCancerDietHistory.getProviderServiceMapID()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getVisitCode()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getDietType()).thenReturn("Diet Type");
    when(benPersonalCancerDietHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benPersonalCancerDietHistory.getPhysicalActivityType()).thenReturn("Physical Activity Type");
    when(benPersonalCancerDietHistory.getProcessed()).thenReturn("Processed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumed()).thenReturn("Type Of Oil Consumed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumedList()).thenReturn(new ArrayList<>());
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistory).getBeneficiaryRegID();
    verify(benPersonalCancerDietHistory).getDietType();
    verify(benPersonalCancerDietHistory).getFruitConsumptionDays();
    verify(benPersonalCancerDietHistory).getFruitQuantityPerDay();
    verify(benPersonalCancerDietHistory).getIntakeOfOutsidePreparedMeal();
    verify(benPersonalCancerDietHistory).getIsThyroidDisorder();
    verify(benPersonalCancerDietHistory).getModifiedBy();
    verify(benPersonalCancerDietHistory).getPhysicalActivityType();
    verify(benPersonalCancerDietHistory).getProcessed();
    verify(benPersonalCancerDietHistory).getProviderServiceMapID();
    verify(benPersonalCancerDietHistory).getSsRadiationExposure();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumed();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).getVegetableConsumptionDays();
    verify(benPersonalCancerDietHistory).getVegetableQuantityPerDay();
    verify(benPersonalCancerDietHistory).getVisitCode();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq("Type Of Oil Consumed"), eq("Physical Activity Type"), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals(1, actualUpdateBenPersonalDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenPersonalDietHistory(BenPersonalCancerDietHistory)}
   */
  @Test
  void testUpdateBenPersonalDietHistory3() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getIsThyroidDisorder()).thenReturn(true);
    when(benPersonalCancerDietHistory.getSsRadiationExposure()).thenReturn(true);
    when(benPersonalCancerDietHistory.getFruitConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getFruitQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal()).thenReturn(1);
    when(benPersonalCancerDietHistory.getProviderServiceMapID()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableConsumptionDays()).thenReturn(1);
    when(benPersonalCancerDietHistory.getVegetableQuantityPerDay()).thenReturn(1);
    when(benPersonalCancerDietHistory.getBeneficiaryRegID()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getVisitCode()).thenReturn(1L);
    when(benPersonalCancerDietHistory.getDietType()).thenReturn("Diet Type");
    when(benPersonalCancerDietHistory.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(benPersonalCancerDietHistory.getPhysicalActivityType()).thenReturn("Physical Activity Type");
    when(benPersonalCancerDietHistory.getProcessed()).thenReturn("Processed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumed()).thenReturn("Type Of Oil Consumed");
    when(benPersonalCancerDietHistory.getTypeOfOilConsumedList()).thenReturn(stringList);
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);

    // Act
    int actualUpdateBenPersonalDietHistoryResult = cSNurseServiceImpl
        .updateBenPersonalDietHistory(benPersonalCancerDietHistory);

    // Assert
    verify(benPersonalCancerDietHistory).getBeneficiaryRegID();
    verify(benPersonalCancerDietHistory).getDietType();
    verify(benPersonalCancerDietHistory).getFruitConsumptionDays();
    verify(benPersonalCancerDietHistory).getFruitQuantityPerDay();
    verify(benPersonalCancerDietHistory).getIntakeOfOutsidePreparedMeal();
    verify(benPersonalCancerDietHistory).getIsThyroidDisorder();
    verify(benPersonalCancerDietHistory).getModifiedBy();
    verify(benPersonalCancerDietHistory).getPhysicalActivityType();
    verify(benPersonalCancerDietHistory).getProcessed();
    verify(benPersonalCancerDietHistory).getProviderServiceMapID();
    verify(benPersonalCancerDietHistory).getSsRadiationExposure();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumed();
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumedList();
    verify(benPersonalCancerDietHistory).getVegetableConsumptionDays();
    verify(benPersonalCancerDietHistory).getVegetableQuantityPerDay();
    verify(benPersonalCancerDietHistory).getVisitCode();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumed(Mockito.<String>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).updateBenPersonalCancerDietHistory(Mockito.<Integer>any(), eq("Diet Type"),
        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), eq("Type Of Oil Consumed"), eq("Physical Activity Type"), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals(1, actualUpdateBenPersonalDietHistoryResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenVitalDetail(BenCancerVitalDetail)}
   */
  @Test
  void testUpdateBenVitalDetail() {
    // Arrange
    when(benCancerVitalDetailRepo.updateBenCancerVitalDetail(Mockito.<Integer>any(), Mockito.<Double>any(),
        Mockito.<Double>any(), Mockito.<Double>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Double>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(1);
    when(benCancerVitalDetailRepo.getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Cancer Vital Status");

    BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");

    // Act
    int actualUpdateBenVitalDetailResult = cSNurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail);

    // Assert
    verify(benCancerVitalDetailRepo).getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benCancerVitalDetailRepo).updateBenCancerVitalDetail(Mockito.<Integer>any(), Mockito.<Double>any(),
        Mockito.<Double>any(), Mockito.<Double>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Double>any(), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("U"), eq("Rbs Test Result"), eq("Rbs Test Remarks"), eq("S PO2"));
    assertEquals(1, actualUpdateBenVitalDetailResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenVitalDetail(BenCancerVitalDetail)}
   */
  @Test
  void testUpdateBenVitalDetail2() {
    // Arrange
    when(benCancerVitalDetailRepo.updateBenCancerVitalDetail(Mockito.<Integer>any(), Mockito.<Double>any(),
        Mockito.<Double>any(), Mockito.<Double>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Double>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(1);
    when(benCancerVitalDetailRepo.getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("N");

    BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");

    // Act
    int actualUpdateBenVitalDetailResult = cSNurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail);

    // Assert
    verify(benCancerVitalDetailRepo).getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benCancerVitalDetailRepo).updateBenCancerVitalDetail(Mockito.<Integer>any(), Mockito.<Double>any(),
        Mockito.<Double>any(), Mockito.<Double>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Short>any(),
        Mockito.<Short>any(), Mockito.<Short>any(), Mockito.<Double>any(), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("N"), eq("Rbs Test Result"), eq("Rbs Test Remarks"), eq("S PO2"));
    assertEquals(1, actualUpdateBenVitalDetailResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateBenVitalDetail(BenCancerVitalDetail)}
   */
  @Test
  void testUpdateBenVitalDetail3() {
    // Arrange
    BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");
    when(benCancerVitalDetailRepo.save(Mockito.<BenCancerVitalDetail>any())).thenReturn(benCancerVitalDetail);
    when(benCancerVitalDetailRepo.getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(null);

    BenCancerVitalDetail benCancerVitalDetail2 = new BenCancerVitalDetail();
    benCancerVitalDetail2.setBenVisitID(1L);
    benCancerVitalDetail2.setBeneficiaryRegID(1L);
    benCancerVitalDetail2.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail2.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail2.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setDeleted(true);
    benCancerVitalDetail2.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setHbA1C((short) 1);
    benCancerVitalDetail2.setHeight_cm(10.0d);
    benCancerVitalDetail2.setHemoglobin(10.0d);
    benCancerVitalDetail2.setID(1L);
    benCancerVitalDetail2.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail2.setParkingPlaceID(1);
    benCancerVitalDetail2.setProcessed("Processed");
    benCancerVitalDetail2.setProviderServiceMapID(1);
    benCancerVitalDetail2.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail2.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail2.setReservedForChange("Reserved For Change");
    benCancerVitalDetail2.setSyncedBy("Synced By");
    benCancerVitalDetail2.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail2.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail2.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail2.setVanID(1);
    benCancerVitalDetail2.setVanSerialNo(1L);
    benCancerVitalDetail2.setVehicalNo("Vehical No");
    benCancerVitalDetail2.setVisitCode(1L);
    benCancerVitalDetail2.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail2.setWeight_Kg(10.0d);
    benCancerVitalDetail2.setsPO2("S PO2");

    // Act
    int actualUpdateBenVitalDetailResult = cSNurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail2);

    // Assert
    verify(benCancerVitalDetailRepo).getCancerVitalStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(benCancerVitalDetailRepo).save(Mockito.<BenCancerVitalDetail>any());
    assertEquals("Jan 1, 2020 9:00am GMT+0100", benCancerVitalDetail2.getCreatedBy());
    assertEquals(1, actualUpdateBenVitalDetailResult);
  }

  /**
   * Method under test: {@link CSNurseServiceImpl#getBenFamilyHisData(Long, Long)}
   */
  @Test
  void testGetBenFamilyHisData() {
    // Arrange
    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    when(benFamilyCancerHistoryRepo.getBenFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benFamilyCancerHistoryList);

    // Act
    List<BenFamilyCancerHistory> actualBenFamilyHisData = cSNurseServiceImpl.getBenFamilyHisData(1L, 1L);

    // Assert
    verify(benFamilyCancerHistoryRepo).getBenFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any());
    assertTrue(actualBenFamilyHisData.isEmpty());
    assertSame(benFamilyCancerHistoryList, actualBenFamilyHisData);
  }

  /**
   * Method under test: {@link CSNurseServiceImpl#getBenFamilyHisData(Long, Long)}
   */
  @Test
  void testGetBenFamilyHisData2() {
    // Arrange
    BenFamilyCancerHistory benFamilyCancerHistory = new BenFamilyCancerHistory();
    benFamilyCancerHistory.setBenVisitID(1L);
    benFamilyCancerHistory.setBeneficiaryRegID(1L);
    benFamilyCancerHistory.setCancerDiseaseType("Cancer Disease Type");
    benFamilyCancerHistory.setCaptureDate(mock(Date.class));
    benFamilyCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benFamilyCancerHistory.setCreatedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setDeleted(true);
    benFamilyCancerHistory.setFamilyMember("Family Member");
    benFamilyCancerHistory.setFamilyMemberList(new ArrayList<>());
    benFamilyCancerHistory.setID(1L);
    benFamilyCancerHistory.setLastModDate(mock(Timestamp.class));
    benFamilyCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benFamilyCancerHistory.setParkingPlaceID(1);
    benFamilyCancerHistory.setProcessed("Processed");
    benFamilyCancerHistory.setProviderServiceMapID(1);
    benFamilyCancerHistory.setReservedForChange("Reserved For Change");
    benFamilyCancerHistory.setSnomedCode("Snomed Code");
    benFamilyCancerHistory.setSnomedTerm("Snomed Term");
    benFamilyCancerHistory.setSyncedBy("Synced By");
    benFamilyCancerHistory.setSyncedDate(mock(Timestamp.class));
    benFamilyCancerHistory.setVanID(1);
    benFamilyCancerHistory.setVanSerialNo(1L);
    benFamilyCancerHistory.setVehicalNo("Vehical No");
    benFamilyCancerHistory.setVisitCode(1L);

    ArrayList<BenFamilyCancerHistory> benFamilyCancerHistoryList = new ArrayList<>();
    benFamilyCancerHistoryList.add(benFamilyCancerHistory);
    when(benFamilyCancerHistoryRepo.getBenFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benFamilyCancerHistoryList);

    // Act
    List<BenFamilyCancerHistory> actualBenFamilyHisData = cSNurseServiceImpl.getBenFamilyHisData(1L, 1L);

    // Assert
    verify(benFamilyCancerHistoryRepo).getBenFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any());
    assertEquals(1, actualBenFamilyHisData.size());
    assertSame(benFamilyCancerHistoryList, actualBenFamilyHisData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenObstetricDetailsData(Long, Long)}
   */
  @Test
  void testGetBenObstetricDetailsData() {
    // Arrange
    BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
    benObstetricCancerHistory.setBenVisitID(1L);
    benObstetricCancerHistory.setBeneficiaryRegID(1L);
    benObstetricCancerHistory.setCaptureDate(mock(Date.class));
    benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setDeleted(true);
    benObstetricCancerHistory.setID(1L);
    benObstetricCancerHistory.setIsAbortion("Is Abortion");
    benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
    benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
    benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
    benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
    benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
    benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
    benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
    benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
    benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
    benObstetricCancerHistory.setMenarche_Age(1);
    benObstetricCancerHistory.setMenopauseAge(1);
    benObstetricCancerHistory.setMenstrualCycleLength(3);
    benObstetricCancerHistory.setMenstrualFlowDuration(1);
    benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
    benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benObstetricCancerHistory.setNoOfLivingChild(1);
    benObstetricCancerHistory.setParkingPlaceID(1);
    benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
    benObstetricCancerHistory.setPregnant_No("Pregnant No");
    benObstetricCancerHistory.setProcessed("Processed");
    benObstetricCancerHistory.setProviderServiceMapID(1);
    benObstetricCancerHistory.setReservedForChange("Reserved For Change");
    benObstetricCancerHistory.setSyncedBy("Synced By");
    benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
    benObstetricCancerHistory.setVanID(1);
    benObstetricCancerHistory.setVanSerialNo(1L);
    benObstetricCancerHistory.setVehicalNo("Vehical No");
    benObstetricCancerHistory.setVisitCode(1L);
    when(benObstetricCancerHistoryRepo.getBenObstetricCancerHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benObstetricCancerHistory);

    // Act
    BenObstetricCancerHistory actualBenObstetricDetailsData = cSNurseServiceImpl.getBenObstetricDetailsData(1L, 1L);

    // Assert
    verify(benObstetricCancerHistoryRepo).getBenObstetricCancerHistory(Mockito.<Long>any(), Mockito.<Long>any());
    assertSame(benObstetricCancerHistory, actualBenObstetricDetailsData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerHistoryData() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);
    when(benPersonalCancerHistoryRepo.getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerHistory);

    // Act
    BenPersonalCancerHistory actualBenPersonalCancerHistoryData = cSNurseServiceImpl.getBenPersonalCancerHistoryData(1L,
        1L);

    // Assert
    verify(benPersonalCancerHistoryRepo).getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any());
    List<String> typeOfTobaccoProductList = actualBenPersonalCancerHistoryData.getTypeOfTobaccoProductList();
    assertEquals(1, typeOfTobaccoProductList.size());
    assertEquals("Type Of Tobacco Product", typeOfTobaccoProductList.get(0));
    assertSame(benPersonalCancerHistory, actualBenPersonalCancerHistoryData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerHistoryData2() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getTypeOfTobaccoProduct()).thenReturn("Type Of Tobacco Product");
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);
    when(benPersonalCancerHistoryRepo.getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerHistory);

    // Act
    cSNurseServiceImpl.getBenPersonalCancerHistoryData(1L, 1L);

    // Assert
    verify(benPersonalCancerHistory).getTypeOfTobaccoProduct();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory).setTypeOfTobaccoProduct(eq("Type Of Tobacco Product"));
    verify(benPersonalCancerHistory, atLeast(1)).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerHistoryData3() {
    // Arrange
    BenPersonalCancerHistory benPersonalCancerHistory = mock(BenPersonalCancerHistory.class);
    when(benPersonalCancerHistory.getTypeOfTobaccoProduct()).thenReturn(null);
    doNothing().when(benPersonalCancerHistory).setAlcoholUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setIsAlcoholUsed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsBetelNutChewing(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsCigaretteExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setIsFilteredCigaerette(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerHistory).setTobaccoUse(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProduct(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
    benPersonalCancerHistory.setBenVisitID(1L);
    benPersonalCancerHistory.setBeneficiaryRegID(1L);
    benPersonalCancerHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setDeleted(true);
    benPersonalCancerHistory.setDurationOfBetelQuid(1);
    benPersonalCancerHistory.setEndAge_year(3);
    benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
    benPersonalCancerHistory.setID(1L);
    benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
    benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
    benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
    benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
    benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerHistory.setParkingPlaceID(1);
    benPersonalCancerHistory.setProcessed("Processed");
    benPersonalCancerHistory.setProviderServiceMapID(1);
    benPersonalCancerHistory.setQuantityPerDay(1);
    benPersonalCancerHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerHistory.setSsAlcoholUsed(true);
    benPersonalCancerHistory.setStartAge_year(1);
    benPersonalCancerHistory.setSyncedBy("Synced By");
    benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
    benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
    benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
    benPersonalCancerHistory.setVanID(1);
    benPersonalCancerHistory.setVanSerialNo(1L);
    benPersonalCancerHistory.setVehicalNo("Vehical No");
    benPersonalCancerHistory.setVisitCode(1L);
    when(benPersonalCancerHistoryRepo.getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerHistory);

    // Act
    cSNurseServiceImpl.getBenPersonalCancerHistoryData(1L, 1L);

    // Assert
    verify(benPersonalCancerHistory).getTypeOfTobaccoProduct();
    verify(benPersonalCancerHistory).setAlcoholUse(eq("Alcohol Use"));
    verify(benPersonalCancerHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setDurationOfBetelQuid(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setEndAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setFrequencyOfAlcoholUsed(eq("Frequency Of Alcohol Used"));
    verify(benPersonalCancerHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setIsAlcoholUsed(eq("Is Alcohol Used"));
    verify(benPersonalCancerHistory).setIsBetelNutChewing(eq("Is Betel Nut Chewing"));
    verify(benPersonalCancerHistory).setIsCigaretteExposure(eq("Is Cigarette Exposure"));
    verify(benPersonalCancerHistory).setIsFilteredCigaerette(eq("Is Filtered Cigaerette"));
    verify(benPersonalCancerHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerHistory).setSsAlcoholUsed(Mockito.<Boolean>any());
    verify(benPersonalCancerHistory).setStartAge_year(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerHistory).setTobaccoUse(eq("Tobacco Use"));
    verify(benPersonalCancerHistory).setTypeOfTobaccoProduct(eq("Type Of Tobacco Product"));
    verify(benPersonalCancerHistory).setTypeOfTobaccoProductList(Mockito.<List<String>>any());
    verify(benPersonalCancerHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerHistoryRepo).getBenPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerDietHistoryData() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerDietHistory);

    // Act
    BenPersonalCancerDietHistory actualBenPersonalCancerDietHistoryData = cSNurseServiceImpl
        .getBenPersonalCancerDietHistoryData(1L, 1L);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any());
    List<String> typeOfOilConsumedList = actualBenPersonalCancerDietHistoryData.getTypeOfOilConsumedList();
    assertEquals(1, typeOfOilConsumedList.size());
    assertEquals("Type Of Oil Consumed", typeOfOilConsumedList.get(0));
    assertSame(benPersonalCancerDietHistory, actualBenPersonalCancerDietHistoryData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerDietHistoryData2() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getTypeOfOilConsumed()).thenReturn("Type Of Oil Consumed");
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerDietHistory);

    // Act
    cSNurseServiceImpl.getBenPersonalCancerDietHistoryData(1L, 1L);

    // Assert
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumed();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumed(eq("Type Of Oil Consumed"));
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenPersonalCancerDietHistoryData(Long, Long)}
   */
  @Test
  void testGetBenPersonalCancerDietHistoryData3() {
    // Arrange
    BenPersonalCancerDietHistory benPersonalCancerDietHistory = mock(BenPersonalCancerDietHistory.class);
    when(benPersonalCancerDietHistory.getTypeOfOilConsumed()).thenReturn(null);
    doNothing().when(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setDietType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setIsRadiationExposure(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setIsThyroidDisorder(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setModifiedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setPhysicalActivityType(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProcessed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setReservedForChange(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedBy(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumed(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    doNothing().when(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    doNothing().when(benPersonalCancerDietHistory).setVehicalNo(Mockito.<String>any());
    doNothing().when(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    benPersonalCancerDietHistory.setBenVisitID(1L);
    benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
    benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
    benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setDeleted(true);
    benPersonalCancerDietHistory.setDietType("Diet Type");
    benPersonalCancerDietHistory.setFruitConsumptionDays(1);
    benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
    benPersonalCancerDietHistory.setID(1L);
    benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
    benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
    benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
    benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benPersonalCancerDietHistory.setParkingPlaceID(1);
    benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
    benPersonalCancerDietHistory.setProcessed("Processed");
    benPersonalCancerDietHistory.setProviderServiceMapID(1);
    benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
    benPersonalCancerDietHistory.setSsRadiationExposure(true);
    benPersonalCancerDietHistory.setSyncedBy("Synced By");
    benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
    benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
    benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
    benPersonalCancerDietHistory.setVanID(1);
    benPersonalCancerDietHistory.setVanSerialNo(1L);
    benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
    benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
    benPersonalCancerDietHistory.setVehicalNo("Vehical No");
    benPersonalCancerDietHistory.setVisitCode(1L);
    when(benPersonalCancerDietHistoryRepo.getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benPersonalCancerDietHistory);

    // Act
    cSNurseServiceImpl.getBenPersonalCancerDietHistoryData(1L, 1L);

    // Assert
    verify(benPersonalCancerDietHistory).getTypeOfOilConsumed();
    verify(benPersonalCancerDietHistory).setBenVisitID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setBeneficiaryRegID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setCaptureDate(Mockito.<Date>any());
    verify(benPersonalCancerDietHistory).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setCreatedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setDeleted(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setDietType(eq("Diet Type"));
    verify(benPersonalCancerDietHistory).setFruitConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setFruitQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setID(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setIntakeOfOutsidePreparedMeal(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setIsRadiationExposure(eq("Is Radiation Exposure"));
    verify(benPersonalCancerDietHistory).setIsThyroidDisorder(eq("Is Thyroid Disorder"));
    verify(benPersonalCancerDietHistory).setLastModDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(benPersonalCancerDietHistory).setParkingPlaceID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setPhysicalActivityType(eq("Physical Activity Type"));
    verify(benPersonalCancerDietHistory).setProcessed(eq("Processed"));
    verify(benPersonalCancerDietHistory).setProviderServiceMapID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setReservedForChange(eq("Reserved For Change"));
    verify(benPersonalCancerDietHistory).setSsRadiationExposure(Mockito.<Boolean>any());
    verify(benPersonalCancerDietHistory).setSyncedBy(eq("Synced By"));
    verify(benPersonalCancerDietHistory).setSyncedDate(Mockito.<Timestamp>any());
    verify(benPersonalCancerDietHistory).setTypeOfOilConsumed(eq("Type Of Oil Consumed"));
    verify(benPersonalCancerDietHistory, atLeast(1)).setTypeOfOilConsumedList(Mockito.<List<String>>any());
    verify(benPersonalCancerDietHistory).setVanID(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVanSerialNo(Mockito.<Long>any());
    verify(benPersonalCancerDietHistory).setVegetableConsumptionDays(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVegetableQuantityPerDay(Mockito.<Integer>any());
    verify(benPersonalCancerDietHistory).setVehicalNo(eq("Vehical No"));
    verify(benPersonalCancerDietHistory).setVisitCode(Mockito.<Long>any());
    verify(benPersonalCancerDietHistoryRepo).getBenPersonaDietHistory(Mockito.<Long>any(), Mockito.<Long>any());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerVitalDetailData(Long, Long)}
   */
  @Test
  void testGetBenCancerVitalDetailData() {
    // Arrange
    BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
    benCancerVitalDetail.setBenVisitID(1L);
    benCancerVitalDetail.setBeneficiaryRegID(1L);
    benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
    benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
    benCancerVitalDetail.setBloodGlucose_Random((short) 1);
    benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
    benCancerVitalDetail.setDeleted(true);
    benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setHbA1C((short) 1);
    benCancerVitalDetail.setHeight_cm(10.0d);
    benCancerVitalDetail.setHemoglobin(10.0d);
    benCancerVitalDetail.setID(1L);
    benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
    benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    benCancerVitalDetail.setParkingPlaceID(1);
    benCancerVitalDetail.setProcessed("Processed");
    benCancerVitalDetail.setProviderServiceMapID(1);
    benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
    benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
    benCancerVitalDetail.setReservedForChange("Reserved For Change");
    benCancerVitalDetail.setSyncedBy("Synced By");
    benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
    benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
    benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
    benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
    benCancerVitalDetail.setVanID(1);
    benCancerVitalDetail.setVanSerialNo(1L);
    benCancerVitalDetail.setVehicalNo("Vehical No");
    benCancerVitalDetail.setVisitCode(1L);
    benCancerVitalDetail.setWaistCircumference_cm(10.0d);
    benCancerVitalDetail.setWeight_Kg(10.0d);
    benCancerVitalDetail.setsPO2("S PO2");
    when(benCancerVitalDetailRepo.getBenCancerVitalDetail(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(benCancerVitalDetail);

    // Act
    BenCancerVitalDetail actualBenCancerVitalDetailData = cSNurseServiceImpl.getBenCancerVitalDetailData(1L, 1L);

    // Assert
    verify(benCancerVitalDetailRepo).getBenCancerVitalDetail(Mockito.<Long>any(), Mockito.<Long>any());
    assertSame(benCancerVitalDetail, actualBenCancerVitalDetailData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerAbdominalExaminationData(Long, Long)}
   */
  @Test
  void testGetBenCancerAbdominalExaminationData() {
    // Arrange
    CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
    cancerAbdominalExamination.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination.setAnyOtherMass_Present(true);
    cancerAbdominalExamination.setAscites_Present(true);
    cancerAbdominalExamination.setBenVisitID(1L);
    cancerAbdominalExamination.setBeneficiaryRegID(1L);
    cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setDeleted(true);
    cancerAbdominalExamination.setID(1L);
    cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination.setLiver("Liver");
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination.setObservation("Observation");
    cancerAbdominalExamination.setParkingPlaceID(1);
    cancerAbdominalExamination.setProcessed("Processed");
    cancerAbdominalExamination.setProviderServiceMapID(1);
    cancerAbdominalExamination.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination.setSyncedBy("Synced By");
    cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setVanID(1);
    cancerAbdominalExamination.setVanSerialNo(1L);
    cancerAbdominalExamination.setVehicalNo("Vehical No");
    cancerAbdominalExamination.setVisitCode(1L);
    when(cancerAbdominalExaminationRepo.getBenCancerAbdominalExaminationDetails(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(cancerAbdominalExamination);

    // Act
    CancerAbdominalExamination actualBenCancerAbdominalExaminationData = cSNurseServiceImpl
        .getBenCancerAbdominalExaminationData(1L, 1L);

    // Assert
    verify(cancerAbdominalExaminationRepo).getBenCancerAbdominalExaminationDetails(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertSame(cancerAbdominalExamination, actualBenCancerAbdominalExaminationData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerBreastExaminationData(Long, Long)}
   */
  @Test
  void testGetBenCancerBreastExaminationData() {
    // Arrange
    CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
    cancerBreastExamination.setBenVisitID(1L);
    cancerBreastExamination.setBeneficiaryRegID(1L);
    cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination.setBreastsAppear_Normal(true);
    cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination.setDeleted(true);
    cancerBreastExamination.setDimplingSkinOnBreast(true);
    cancerBreastExamination.setDischargeFromNipple(true);
    cancerBreastExamination.setEverBreastFed(true);
    cancerBreastExamination.setID(1L);
    cancerBreastExamination.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination.setLumpInBreast(true);
    cancerBreastExamination.setLumpShape("Lump Shape");
    cancerBreastExamination.setLumpSize("Lump Size");
    cancerBreastExamination.setLumpTexture("Lump Texture");
    cancerBreastExamination.setMamogramReport("Mamogram Report");
    cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination.setParkingPlaceID(1);
    cancerBreastExamination.setPeaudOrange(true);
    cancerBreastExamination.setProcessed("Processed");
    cancerBreastExamination.setProviderServiceMapID(1);
    cancerBreastExamination.setRashOnBreast(true);
    cancerBreastExamination.setReferredToMammogram(true);
    cancerBreastExamination.setReservedForChange("Reserved For Change");
    cancerBreastExamination.setSyncedBy("Synced By");
    cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination.setVanID(1);
    cancerBreastExamination.setVanSerialNo(1L);
    cancerBreastExamination.setVehicalNo("Vehical No");
    cancerBreastExamination.setVisitCode(1L);
    when(cancerBreastExaminationRepo.getBenCancerBreastExaminationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(cancerBreastExamination);

    // Act
    CancerBreastExamination actualBenCancerBreastExaminationData = cSNurseServiceImpl
        .getBenCancerBreastExaminationData(1L, 1L);

    // Assert
    verify(cancerBreastExaminationRepo).getBenCancerBreastExaminationDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertSame(cancerBreastExamination, actualBenCancerBreastExaminationData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerGynecologicalExaminationData(Long, Long)}
   */
  @Test
  void testGetBenCancerGynecologicalExaminationData() {
    // Arrange
    CancerGynecologicalExamination cancerGynecologicalExamination = new CancerGynecologicalExamination();
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");
    when(cancerGynecologicalExaminationRepo.getBenCancerGynecologicalExaminationDetails(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(cancerGynecologicalExamination);

    // Act
    CancerGynecologicalExamination actualBenCancerGynecologicalExaminationData = cSNurseServiceImpl
        .getBenCancerGynecologicalExaminationData(1L, 1L);

    // Assert
    verify(cancerGynecologicalExaminationRepo).getBenCancerGynecologicalExaminationDetails(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertSame(cancerGynecologicalExamination, actualBenCancerGynecologicalExaminationData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerSignAndSymptomsData(Long, Long)}
   */
  @Test
  void testGetBenCancerSignAndSymptomsData() {
    // Arrange
    CancerSignAndSymptoms cancerSignAndSymptoms = new CancerSignAndSymptoms();
    cancerSignAndSymptoms.setBenVisitID(1L);
    cancerSignAndSymptoms.setBeneficiaryRegID(1L);
    cancerSignAndSymptoms.setBloodInSputum(true);
    cancerSignAndSymptoms.setBloodStainedDischargeFromNipple(true);
    cancerSignAndSymptoms.setBreastEnlargement(true);
    cancerSignAndSymptoms.setBriefHistory("Observation");
    cancerSignAndSymptoms.setChangeInShapeAndSizeOfBreasts(true);
    cancerSignAndSymptoms.setChangeInTheToneOfVoice(true);
    cancerSignAndSymptoms.setCoughGTE2Weeks(true);
    cancerSignAndSymptoms.setCoughgt2Weeks(true);
    cancerSignAndSymptoms.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerSignAndSymptoms.setCreatedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setDeleted(true);
    cancerSignAndSymptoms.setDifficultyInOpeningMouth(true);
    cancerSignAndSymptoms.setFoulSmellingVaginalDischarge(true);
    cancerSignAndSymptoms.setID(1L);
    cancerSignAndSymptoms.setLastModDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setLumpInTheBreast(true);
    cancerSignAndSymptoms.setLymphNode_Enlarged(true);
    cancerSignAndSymptoms.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerSignAndSymptoms.setNonHealingUlcerOrPatchOrGrowth(true);
    cancerSignAndSymptoms.setObservation("Observation");
    cancerSignAndSymptoms.setParkingPlaceID(1);
    cancerSignAndSymptoms.setProcessed("Processed");
    cancerSignAndSymptoms.setProviderServiceMapID(1);
    cancerSignAndSymptoms.setReservedForChange("Reserved For Change");
    cancerSignAndSymptoms.setShortnessOfBreath(true);
    cancerSignAndSymptoms.setSyncedBy("Synced By");
    cancerSignAndSymptoms.setSyncedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setVaginalBleedingAfterIntercourse(true);
    cancerSignAndSymptoms.setVaginalBleedingAfterMenopause(true);
    cancerSignAndSymptoms.setVaginalBleedingBetweenPeriods(true);
    cancerSignAndSymptoms.setVanID(1);
    cancerSignAndSymptoms.setVanSerialNo(1L);
    cancerSignAndSymptoms.setVehicalNo("Vehical No");
    cancerSignAndSymptoms.setVisitCode(1L);
    when(cancerSignAndSymptomsRepo.getBenCancerSignAndSymptomsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(cancerSignAndSymptoms);

    // Act
    CancerSignAndSymptoms actualBenCancerSignAndSymptomsData = cSNurseServiceImpl.getBenCancerSignAndSymptomsData(1L,
        1L);

    // Assert
    verify(cancerSignAndSymptomsRepo).getBenCancerSignAndSymptomsDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertSame(cancerSignAndSymptoms, actualBenCancerSignAndSymptomsData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerLymphNodeDetailsData(Long, Long)}
   */
  @Test
  void testGetBenCancerLymphNodeDetailsData() {
    // Arrange
    ArrayList<CancerLymphNodeDetails> cancerLymphNodeDetailsList = new ArrayList<>();
    when(cancerLymphNodeExaminationRepo.getBenCancerLymphNodeDetails(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(cancerLymphNodeDetailsList);

    // Act
    List<CancerLymphNodeDetails> actualBenCancerLymphNodeDetailsData = cSNurseServiceImpl
        .getBenCancerLymphNodeDetailsData(1L, 1L);

    // Assert
    verify(cancerLymphNodeExaminationRepo).getBenCancerLymphNodeDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertTrue(actualBenCancerLymphNodeDetailsData.isEmpty());
    assertSame(cancerLymphNodeDetailsList, actualBenCancerLymphNodeDetailsData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerOralExaminationData(Long, Long)}
   */
  @Test
  void testGetBenCancerOralExaminationData() {
    // Arrange
    CancerOralExamination cancerOralExamination = new CancerOralExamination();
    cancerOralExamination.setBenVisitID(1L);
    cancerOralExamination.setBeneficiaryRegID(1L);
    cancerOralExamination.setChronicBurningSensation(true);
    cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination.setDeleted(true);
    cancerOralExamination.setID(1L);
    cancerOralExamination.setLastModDate(mock(Timestamp.class));
    cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination.setObservation("Observation");
    cancerOralExamination.setParkingPlaceID(1);
    cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
    cancerOralExamination.setPremalignantLesions(true);
    cancerOralExamination.setProcessed("Processed");
    cancerOralExamination.setProlongedIrritation(true);
    cancerOralExamination.setProviderServiceMapID(1);
    cancerOralExamination.setReservedForChange("Reserved For Change");
    cancerOralExamination.setSyncedBy("Synced By");
    cancerOralExamination.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination.setVanID(1);
    cancerOralExamination.setVanSerialNo(1L);
    cancerOralExamination.setVehicalNo("Vehical No");
    cancerOralExamination.setVisitCode(1L);
    when(cancerOralExaminationRepo.getBenCancerOralExaminationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(cancerOralExamination);

    // Act
    CancerOralExamination actualBenCancerOralExaminationData = cSNurseServiceImpl.getBenCancerOralExaminationData(1L,
        1L);

    // Assert
    verify(cancerOralExaminationRepo).getBenCancerOralExaminationDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertSame(cancerOralExamination, actualBenCancerOralExaminationData);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationCasesheet(Long, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationCasesheet() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    ArrayList<WrapperCancerExamImgAnotasn> actualCancerExaminationImageAnnotationCasesheet = cSNurseServiceImpl
        .getCancerExaminationImageAnnotationCasesheet(1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertTrue(actualCancerExaminationImageAnnotationCasesheet.isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationCasesheet(Long, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationCasesheet2() {
    // Arrange
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(cancerExaminationImageAnnotationList);

    // Act
    ArrayList<WrapperCancerExamImgAnotasn> actualCancerExaminationImageAnnotationCasesheet = cSNurseServiceImpl
        .getCancerExaminationImageAnnotationCasesheet(1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertEquals(1, actualCancerExaminationImageAnnotationCasesheet.size());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationCasesheet(Long, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationCasesheet3() {
    // Arrange
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getProviderServiceMapID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getBenVisitID()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getVisitCode()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getPoint()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getyCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getPointDesc()).thenReturn("Point Desc");
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(cancerExaminationImageAnnotationList);

    // Act
    ArrayList<WrapperCancerExamImgAnotasn> actualCancerExaminationImageAnnotationCasesheet = cSNurseServiceImpl
        .getCancerExaminationImageAnnotationCasesheet(1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotation).getBenVisitID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getCreatedBy();
    verify(cancerExaminationImageAnnotation).getPoint();
    verify(cancerExaminationImageAnnotation).getPointDesc();
    verify(cancerExaminationImageAnnotation).getProviderServiceMapID();
    verify(cancerExaminationImageAnnotation).getVisitCode();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).getyCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertEquals(1, actualCancerExaminationImageAnnotationCasesheet.size());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationCasesheet(Long, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationCasesheet4() {
    // Arrange
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(0);
    when(cancerExaminationImageAnnotation.getPoint()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getyCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getPointDesc()).thenReturn("Point Desc");
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(cancerExaminationImageAnnotationList);

    // Act
    ArrayList<WrapperCancerExamImgAnotasn> actualCancerExaminationImageAnnotationCasesheet = cSNurseServiceImpl
        .getCancerExaminationImageAnnotationCasesheet(1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotation).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getPoint();
    verify(cancerExaminationImageAnnotation).getPointDesc();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).getyCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationList(Mockito.<Long>any(),
        Mockito.<Long>any());
    assertTrue(actualCancerExaminationImageAnnotationCasesheet.isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenNurseDataForCaseSheet(Long, Long)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetBenNurseDataForCaseSheet() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    // TODO: Populate arranged inputs
    Long benRegID = null;
    Long visitCode = null;

    // Act
    Map<String, Object> actualBenNurseDataForCaseSheet = this.cSNurseServiceImpl.getBenNurseDataForCaseSheet(benRegID,
        visitCode);

    // Assert
    // TODO: Add assertions on result
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBeneficiaryVisitDetails(Long, Long)}
   */
  @Test
  void testGetBeneficiaryVisitDetails() {
    // Arrange
    when(benVisitDetailRepo.getBeneficiaryVisitDetails(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    BeneficiaryVisitDetail actualBeneficiaryVisitDetails = cSNurseServiceImpl.getBeneficiaryVisitDetails(1L, 1L);

    // Assert
    verify(benVisitDetailRepo).getBeneficiaryVisitDetails(Mockito.<Long>any(), Mockito.<Long>any());
    assertNull(actualBeneficiaryVisitDetails);
  }

  /**
   * Method under test: {@link CSNurseServiceImpl#getBenCancerFamilyHistory(Long)}
   */
  @Test
  void testGetBenCancerFamilyHistory() {
    // Arrange
    when(benFamilyCancerHistoryRepo.getBenCancerFamilyHistory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    String actualBenCancerFamilyHistory = cSNurseServiceImpl.getBenCancerFamilyHistory(1L);

    // Assert
    verify(benFamilyCancerHistoryRepo).getBenCancerFamilyHistory(Mockito.<Long>any());
    assertEquals(
        "{\"data\":[],\"columns\":[{\"keyName\":\"captureDate\",\"columnName\":\"Date of Capture\"},{\"keyName\":"
            + "\"cancerDiseaseType\",\"columnName\":\"Cancer Disease Type\"},{\"keyName\":\"familyMember\",\"columnName\":\"Family"
            + " Members\"}]}",
        actualBenCancerFamilyHistory);
  }

  /**
   * Method under test: {@link CSNurseServiceImpl#getBenCancerFamilyHistory(Long)}
   */
  @Test
  void testGetBenCancerFamilyHistory2() {
    // Arrange
    Date date = mock(Date.class);
    when(date.getTime()).thenReturn(10L);

    ArrayList<Object[]> objectArrayList = new ArrayList<>();
    objectArrayList.add(new Object[]{"42", "42", date});
    when(benFamilyCancerHistoryRepo.getBenCancerFamilyHistory(Mockito.<Long>any())).thenReturn(objectArrayList);

    // Act
    cSNurseServiceImpl.getBenCancerFamilyHistory(1L);

    // Assert
    verify(benFamilyCancerHistoryRepo).getBenCancerFamilyHistory(Mockito.<Long>any());
    verify(date).getTime();
  }

  /**
   * Method under test: {@link CSNurseServiceImpl#getBenCancerFamilyHistory(Long)}
   */
  @Test
  void testGetBenCancerFamilyHistory3() {
    // Arrange
    Date date = mock(Date.class);
    when(date.getTime()).thenReturn(10L);

    ArrayList<Object[]> objectArrayList = new ArrayList<>();
    objectArrayList.add(new Object[]{"", "42", date});
    when(benFamilyCancerHistoryRepo.getBenCancerFamilyHistory(Mockito.<Long>any())).thenReturn(objectArrayList);

    // Act
    cSNurseServiceImpl.getBenCancerFamilyHistory(1L);

    // Assert
    verify(benFamilyCancerHistoryRepo).getBenCancerFamilyHistory(Mockito.<Long>any());
    verify(date).getTime();
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerPersonalHistory(Long)}
   */
  @Test
  void testGetBenCancerPersonalHistory() {
    // Arrange
    when(benPersonalCancerHistoryRepo.getBenPersonalHistory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    String actualBenCancerPersonalHistory = cSNurseServiceImpl.getBenCancerPersonalHistory(1L);

    // Assert
    verify(benPersonalCancerHistoryRepo).getBenPersonalHistory(Mockito.<Long>any());
    assertEquals(
        "{\"data\":[],\"columns\":[{\"keyName\":\"captureDate\",\"columnName\":\"Date of Capture\"},{\"keyName\":\"tobaccoUse"
            + "\",\"columnName\":\"Tobacco Use Status\"},{\"keyName\":\"startAge_year\",\"columnName\":\"Start Age(Years)\"},{"
            + "\"keyName\":\"endAge_year\",\"columnName\":\"Stop Age(Years)\"},{\"keyName\":\"typeOfTobaccoProduct\",\"columnName\":\"Type"
            + " Of Tobacco Product\"},{\"keyName\":\"quantityPerDay\",\"columnName\":\"Quantity(Per Day)\"},{\"keyName\":"
            + "\"IsFilteredCigaerette\",\"columnName\":\"Filtered Cigarette\"},{\"keyName\":\"IsCigaretteExposure\",\"columnName"
            + "\":\"Exposure to Cigarette\"},{\"keyName\":\"IsBetelNutChewing\",\"columnName\":\"Betel Nut Chewing\"},{\"keyName"
            + "\":\"durationOfBetelQuid\",\"columnName\":\"Duration Of Betel Quid in Mouth(Mins)\"},{\"keyName\":\"alcoholUse"
            + "\",\"columnName\":\"Alcohol use Status\"},{\"keyName\":\"IsAlcoholUsed\",\"columnName\":\"Alcohol Consumed(within"
            + " 12 months)\"},{\"keyName\":\"frequencyOfAlcoholUsed\",\"columnName\":\"Frequency Of Alcohol Use(within 12"
            + " months)\"}]}",
        actualBenCancerPersonalHistory);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerPersonalDietHistory(Long)}
   */
  @Test
  void testGetBenCancerPersonalDietHistory() {
    // Arrange
    when(benPersonalCancerDietHistoryRepo.getBenPersonaDietHistory(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    String actualBenCancerPersonalDietHistory = cSNurseServiceImpl.getBenCancerPersonalDietHistory(1L);

    // Assert
    verify(benPersonalCancerDietHistoryRepo).getBenPersonaDietHistory(Mockito.<Long>any());
    assertEquals(
        "{\"data\":[],\"columns\":[{\"keyName\":\"captureDate\",\"columnName\":\"Date of Capture\"},{\"keyName\":\"dietType\""
            + ",\"columnName\":\"Diet Type\"},{\"keyName\":\"fruitConsumptionDays\",\"columnName\":\"Fruit Consumption(Days/week"
            + ")\"},{\"keyName\":\"fruitQuantityPerDay\",\"columnName\":\"Fruit Quantity(Cups/day)\"},{\"keyName\":\"vegetableC"
            + "onsumptionDays\",\"columnName\":\"Vegetable Consumption(Days/week)\"},{\"keyName\":\"vegetableQuantityPerDay"
            + "\",\"columnName\":\"Vegetable Quantity(Cups/day)\"},{\"keyName\":\"intakeOfOutsidePreparedMeal\",\"columnName\":\"Weekly"
            + " Intake Of Outside Prepared Meal\"},{\"keyName\":\"typeOfOilConsumed\",\"columnName\":\"Type Of Oil"
            + " Consumed\"},{\"keyName\":\"physicalActivityType\",\"columnName\":\"Physical Activity Type\"},{\"keyName\":"
            + "\"IsRadiationExposure\",\"columnName\":\"History of exposure to radiation\"},{\"keyName\":\"IsThyroidDisorder"
            + "\",\"columnName\":\"History of any thyroid disorder\"}]}",
        actualBenCancerPersonalDietHistory);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getBenCancerObstetricHistory(Long)}
   */
  @Test
  void testGetBenCancerObstetricHistory() {
    // Arrange
    when(benObstetricCancerHistoryRepo.getBenObstetricCancerHistoryData(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    String actualBenCancerObstetricHistory = cSNurseServiceImpl.getBenCancerObstetricHistory(1L);

    // Assert
    verify(benObstetricCancerHistoryRepo).getBenObstetricCancerHistoryData(Mockito.<Long>any());
    assertEquals(
        "{\"data\":[],\"columns\":[{\"keyName\":\"captureDate\",\"columnName\":\"Date of Capture\"},{\"keyName\":\"pregnancyStatus"
            + "\",\"columnName\":\"Pregnancy Status\"},{\"keyName\":\"IsUrinePregTest\",\"columnName\":\"Urine pregnancy"
            + " test\"},{\"keyName\":\"pregnant_No\",\"columnName\":\"No of times Pregnant\"},{\"keyName\":\"noOfLivingChild\","
            + "\"columnName\":\"No of Living Children\"},{\"keyName\":\"IsAbortion\",\"columnName\":\"Abortions\"},{\"keyName\":"
            + "\"IsOralContraceptiveUsed\",\"columnName\":\"Oral Contraceptives used in 5 years\"},{\"keyName\":\"IsHormoneR"
            + "eplacementTherapy\",\"columnName\":\"Hormone replacement Therapy in 5yrs\"},{\"keyName\":\"menarche_Age\","
            + "\"columnName\":\"Age at menarche(Years)\"},{\"keyName\":\"IsMenstrualCycleRegular\",\"columnName\":\"Regularity"
            + " of Menstrual Cycle\"},{\"keyName\":\"menstrualCycleLength\",\"columnName\":\"Length of Menstrual Cycle(in"
            + " days)\"},{\"keyName\":\"menstrualFlowDuration\",\"columnName\":\"Menstrual Flow Duration(Days)\"},{\"keyName\""
            + ":\"menstrualFlowType\",\"columnName\":\"Type of Flow\"},{\"keyName\":\"IsDysmenorrhea\",\"columnName\":\"Dysmenorrhea"
            + "\"},{\"keyName\":\"IsInterMenstrualBleeding\",\"columnName\":\"Inter menstrual bleeding\"},{\"keyName\":\"menopauseAge"
            + "\",\"columnName\":\"Age at Menopause(Years)\"},{\"keyName\":\"IsPostMenopauseBleeding\",\"columnName\":\"Post-menopausal"
            + " Bleeding\"}]}",
        actualBenCancerObstetricHistory);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveLymphNodeDetails(List, Long, Long)}
   */
  @Test
  void testSaveLymphNodeDetails() {
    // Arrange
    when(cancerLymphNodeExaminationRepo.saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Long actualSaveLymphNodeDetailsResult = cSNurseServiceImpl.saveLymphNodeDetails(new ArrayList<>(), 1L, 1L);

    // Assert
    verify(cancerLymphNodeExaminationRepo).saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any());
    assertNull(actualSaveLymphNodeDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveLymphNodeDetails(List, Long, Long)}
   */
  @Test
  void testSaveLymphNodeDetails2() {
    // Arrange
    CancerLymphNodeDetails cancerLymphNodeDetails = new CancerLymphNodeDetails();
    cancerLymphNodeDetails.setBenVisitID(1L);
    cancerLymphNodeDetails.setBeneficiaryRegID(1L);
    cancerLymphNodeDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerLymphNodeDetails.setCreatedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setDeleted(true);
    cancerLymphNodeDetails.setID(1L);
    cancerLymphNodeDetails.setLastModDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setLymphNodeName("Lymph Node Name");
    cancerLymphNodeDetails.setMobility_Left(true);
    cancerLymphNodeDetails.setMobility_Right(true);
    cancerLymphNodeDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerLymphNodeDetails.setParkingPlaceID(1);
    cancerLymphNodeDetails.setProcessed("Processed");
    cancerLymphNodeDetails.setProviderServiceMapID(1);
    cancerLymphNodeDetails.setReservedForChange("Reserved For Change");
    cancerLymphNodeDetails.setSize_Left("Size Left");
    cancerLymphNodeDetails.setSize_Right("Size Right");
    cancerLymphNodeDetails.setSyncedBy("Synced By");
    cancerLymphNodeDetails.setSyncedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setVanID(1);
    cancerLymphNodeDetails.setVanSerialNo(1L);
    cancerLymphNodeDetails.setVehicalNo("Vehical No");
    cancerLymphNodeDetails.setVisitCode(1L);

    ArrayList<CancerLymphNodeDetails> cancerLymphNodeDetailsList = new ArrayList<>();
    cancerLymphNodeDetailsList.add(cancerLymphNodeDetails);
    when(cancerLymphNodeExaminationRepo.saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any()))
        .thenReturn(cancerLymphNodeDetailsList);

    // Act
    Long actualSaveLymphNodeDetailsResult = cSNurseServiceImpl.saveLymphNodeDetails(new ArrayList<>(), 1L, 1L);

    // Assert
    verify(cancerLymphNodeExaminationRepo).saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any());
    assertEquals(1L, actualSaveLymphNodeDetailsResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveLymphNodeDetails(List, Long, Long)}
   */
  @Test
  void testSaveLymphNodeDetails3() {
    // Arrange
    when(cancerLymphNodeExaminationRepo.saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any()))
        .thenReturn(new ArrayList<>());

    CancerLymphNodeDetails cancerLymphNodeDetails = new CancerLymphNodeDetails();
    cancerLymphNodeDetails.setBenVisitID(1L);
    cancerLymphNodeDetails.setBeneficiaryRegID(1L);
    cancerLymphNodeDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerLymphNodeDetails.setCreatedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setDeleted(true);
    cancerLymphNodeDetails.setID(1L);
    cancerLymphNodeDetails.setLastModDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setLymphNodeName("Lymph Node Name");
    cancerLymphNodeDetails.setMobility_Left(true);
    cancerLymphNodeDetails.setMobility_Right(true);
    cancerLymphNodeDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerLymphNodeDetails.setParkingPlaceID(1);
    cancerLymphNodeDetails.setProcessed("Processed");
    cancerLymphNodeDetails.setProviderServiceMapID(1);
    cancerLymphNodeDetails.setReservedForChange("Reserved For Change");
    cancerLymphNodeDetails.setSize_Left("Size Left");
    cancerLymphNodeDetails.setSize_Right("Size Right");
    cancerLymphNodeDetails.setSyncedBy("Synced By");
    cancerLymphNodeDetails.setSyncedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setVanID(1);
    cancerLymphNodeDetails.setVanSerialNo(1L);
    cancerLymphNodeDetails.setVehicalNo("Vehical No");
    cancerLymphNodeDetails.setVisitCode(1L);

    ArrayList<CancerLymphNodeDetails> cancerLymphNodeDetails2 = new ArrayList<>();
    cancerLymphNodeDetails2.add(cancerLymphNodeDetails);

    // Act
    Long actualSaveLymphNodeDetailsResult = cSNurseServiceImpl.saveLymphNodeDetails(cancerLymphNodeDetails2, 1L, 1L);

    // Assert
    verify(cancerLymphNodeExaminationRepo).saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any());
    assertNull(actualSaveLymphNodeDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveLymphNodeDetails(List, Long, Long)}
   */
  @Test
  void testSaveLymphNodeDetails4() {
    // Arrange
    when(cancerLymphNodeExaminationRepo.saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any()))
        .thenReturn(new ArrayList<>());

    CancerLymphNodeDetails cancerLymphNodeDetails = new CancerLymphNodeDetails();
    cancerLymphNodeDetails.setBenVisitID(1L);
    cancerLymphNodeDetails.setBeneficiaryRegID(1L);
    cancerLymphNodeDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerLymphNodeDetails.setCreatedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setDeleted(true);
    cancerLymphNodeDetails.setID(1L);
    cancerLymphNodeDetails.setLastModDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setLymphNodeName("Lymph Node Name");
    cancerLymphNodeDetails.setMobility_Left(true);
    cancerLymphNodeDetails.setMobility_Right(true);
    cancerLymphNodeDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerLymphNodeDetails.setParkingPlaceID(1);
    cancerLymphNodeDetails.setProcessed("Processed");
    cancerLymphNodeDetails.setProviderServiceMapID(1);
    cancerLymphNodeDetails.setReservedForChange("Reserved For Change");
    cancerLymphNodeDetails.setSize_Left("Size Left");
    cancerLymphNodeDetails.setSize_Right("Size Right");
    cancerLymphNodeDetails.setSyncedBy("Synced By");
    cancerLymphNodeDetails.setSyncedDate(mock(Timestamp.class));
    cancerLymphNodeDetails.setVanID(1);
    cancerLymphNodeDetails.setVanSerialNo(1L);
    cancerLymphNodeDetails.setVehicalNo("Vehical No");
    cancerLymphNodeDetails.setVisitCode(1L);

    CancerLymphNodeDetails cancerLymphNodeDetails2 = new CancerLymphNodeDetails();
    cancerLymphNodeDetails2.setBenVisitID(2L);
    cancerLymphNodeDetails2.setBeneficiaryRegID(2L);
    cancerLymphNodeDetails2.setCreatedBy("Created By");
    cancerLymphNodeDetails2.setCreatedDate(mock(Timestamp.class));
    cancerLymphNodeDetails2.setDeleted(false);
    cancerLymphNodeDetails2.setID(2L);
    cancerLymphNodeDetails2.setLastModDate(mock(Timestamp.class));
    cancerLymphNodeDetails2.setLymphNodeName("42");
    cancerLymphNodeDetails2.setMobility_Left(false);
    cancerLymphNodeDetails2.setMobility_Right(false);
    cancerLymphNodeDetails2.setModifiedBy("Modified By");
    cancerLymphNodeDetails2.setParkingPlaceID(2);
    cancerLymphNodeDetails2.setProcessed("42");
    cancerLymphNodeDetails2.setProviderServiceMapID(2);
    cancerLymphNodeDetails2.setReservedForChange("42");
    cancerLymphNodeDetails2.setSize_Left("42");
    cancerLymphNodeDetails2.setSize_Right("42");
    cancerLymphNodeDetails2.setSyncedBy("42");
    cancerLymphNodeDetails2.setSyncedDate(mock(Timestamp.class));
    cancerLymphNodeDetails2.setVanID(2);
    cancerLymphNodeDetails2.setVanSerialNo(0L);
    cancerLymphNodeDetails2.setVehicalNo("42");
    cancerLymphNodeDetails2.setVisitCode(0L);

    ArrayList<CancerLymphNodeDetails> cancerLymphNodeDetails3 = new ArrayList<>();
    cancerLymphNodeDetails3.add(cancerLymphNodeDetails2);
    cancerLymphNodeDetails3.add(cancerLymphNodeDetails);

    // Act
    Long actualSaveLymphNodeDetailsResult = cSNurseServiceImpl.saveLymphNodeDetails(cancerLymphNodeDetails3, 1L, 1L);

    // Assert
    verify(cancerLymphNodeExaminationRepo).saveAll(Mockito.<Iterable<CancerLymphNodeDetails>>any());
    assertNull(actualSaveLymphNodeDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerSignAndSymptomsData(CancerSignAndSymptoms)}
   */
  @Test
  void testSaveCancerSignAndSymptomsData() {
    // Arrange
    CancerSignAndSymptoms cancerSignAndSymptoms = new CancerSignAndSymptoms();
    cancerSignAndSymptoms.setBenVisitID(1L);
    cancerSignAndSymptoms.setBeneficiaryRegID(1L);
    cancerSignAndSymptoms.setBloodInSputum(true);
    cancerSignAndSymptoms.setBloodStainedDischargeFromNipple(true);
    cancerSignAndSymptoms.setBreastEnlargement(true);
    cancerSignAndSymptoms.setBriefHistory("Observation");
    cancerSignAndSymptoms.setChangeInShapeAndSizeOfBreasts(true);
    cancerSignAndSymptoms.setChangeInTheToneOfVoice(true);
    cancerSignAndSymptoms.setCoughGTE2Weeks(true);
    cancerSignAndSymptoms.setCoughgt2Weeks(true);
    cancerSignAndSymptoms.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerSignAndSymptoms.setCreatedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setDeleted(true);
    cancerSignAndSymptoms.setDifficultyInOpeningMouth(true);
    cancerSignAndSymptoms.setFoulSmellingVaginalDischarge(true);
    cancerSignAndSymptoms.setID(1L);
    cancerSignAndSymptoms.setLastModDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setLumpInTheBreast(true);
    cancerSignAndSymptoms.setLymphNode_Enlarged(true);
    cancerSignAndSymptoms.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerSignAndSymptoms.setNonHealingUlcerOrPatchOrGrowth(true);
    cancerSignAndSymptoms.setObservation("Observation");
    cancerSignAndSymptoms.setParkingPlaceID(1);
    cancerSignAndSymptoms.setProcessed("Processed");
    cancerSignAndSymptoms.setProviderServiceMapID(1);
    cancerSignAndSymptoms.setReservedForChange("Reserved For Change");
    cancerSignAndSymptoms.setShortnessOfBreath(true);
    cancerSignAndSymptoms.setSyncedBy("Synced By");
    cancerSignAndSymptoms.setSyncedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setVaginalBleedingAfterIntercourse(true);
    cancerSignAndSymptoms.setVaginalBleedingAfterMenopause(true);
    cancerSignAndSymptoms.setVaginalBleedingBetweenPeriods(true);
    cancerSignAndSymptoms.setVanID(1);
    cancerSignAndSymptoms.setVanSerialNo(1L);
    cancerSignAndSymptoms.setVehicalNo("Vehical No");
    cancerSignAndSymptoms.setVisitCode(1L);
    when(cancerSignAndSymptomsRepo.save(Mockito.<CancerSignAndSymptoms>any())).thenReturn(cancerSignAndSymptoms);

    CancerSignAndSymptoms cancerSignAndSymptoms2 = new CancerSignAndSymptoms();
    cancerSignAndSymptoms2.setBenVisitID(1L);
    cancerSignAndSymptoms2.setBeneficiaryRegID(1L);
    cancerSignAndSymptoms2.setBloodInSputum(true);
    cancerSignAndSymptoms2.setBloodStainedDischargeFromNipple(true);
    cancerSignAndSymptoms2.setBreastEnlargement(true);
    cancerSignAndSymptoms2.setBriefHistory("Observation");
    cancerSignAndSymptoms2.setChangeInShapeAndSizeOfBreasts(true);
    cancerSignAndSymptoms2.setChangeInTheToneOfVoice(true);
    cancerSignAndSymptoms2.setCoughGTE2Weeks(true);
    cancerSignAndSymptoms2.setCoughgt2Weeks(true);
    cancerSignAndSymptoms2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerSignAndSymptoms2.setCreatedDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setDeleted(true);
    cancerSignAndSymptoms2.setDifficultyInOpeningMouth(true);
    cancerSignAndSymptoms2.setFoulSmellingVaginalDischarge(true);
    cancerSignAndSymptoms2.setID(1L);
    cancerSignAndSymptoms2.setLastModDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setLumpInTheBreast(true);
    cancerSignAndSymptoms2.setLymphNode_Enlarged(true);
    cancerSignAndSymptoms2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerSignAndSymptoms2.setNonHealingUlcerOrPatchOrGrowth(true);
    cancerSignAndSymptoms2.setObservation("Observation");
    cancerSignAndSymptoms2.setParkingPlaceID(1);
    cancerSignAndSymptoms2.setProcessed("Processed");
    cancerSignAndSymptoms2.setProviderServiceMapID(1);
    cancerSignAndSymptoms2.setReservedForChange("Reserved For Change");
    cancerSignAndSymptoms2.setShortnessOfBreath(true);
    cancerSignAndSymptoms2.setSyncedBy("Synced By");
    cancerSignAndSymptoms2.setSyncedDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setVaginalBleedingAfterIntercourse(true);
    cancerSignAndSymptoms2.setVaginalBleedingAfterMenopause(true);
    cancerSignAndSymptoms2.setVaginalBleedingBetweenPeriods(true);
    cancerSignAndSymptoms2.setVanID(1);
    cancerSignAndSymptoms2.setVanSerialNo(1L);
    cancerSignAndSymptoms2.setVehicalNo("Vehical No");
    cancerSignAndSymptoms2.setVisitCode(1L);

    // Act
    Long actualSaveCancerSignAndSymptomsDataResult = cSNurseServiceImpl
        .saveCancerSignAndSymptomsData(cancerSignAndSymptoms2);

    // Assert
    verify(cancerSignAndSymptomsRepo).save(Mockito.<CancerSignAndSymptoms>any());
    assertEquals(1L, actualSaveCancerSignAndSymptomsDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerSignAndSymptomsData(CancerSignAndSymptoms, Long, Long)}
   */
  @Test
  void testSaveCancerSignAndSymptomsData2() {
    // Arrange
    CancerSignAndSymptoms cancerSignAndSymptoms = new CancerSignAndSymptoms();
    cancerSignAndSymptoms.setBenVisitID(1L);
    cancerSignAndSymptoms.setBeneficiaryRegID(1L);
    cancerSignAndSymptoms.setBloodInSputum(true);
    cancerSignAndSymptoms.setBloodStainedDischargeFromNipple(true);
    cancerSignAndSymptoms.setBreastEnlargement(true);
    cancerSignAndSymptoms.setBriefHistory("Observation");
    cancerSignAndSymptoms.setChangeInShapeAndSizeOfBreasts(true);
    cancerSignAndSymptoms.setChangeInTheToneOfVoice(true);
    cancerSignAndSymptoms.setCoughGTE2Weeks(true);
    cancerSignAndSymptoms.setCoughgt2Weeks(true);
    cancerSignAndSymptoms.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerSignAndSymptoms.setCreatedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setDeleted(true);
    cancerSignAndSymptoms.setDifficultyInOpeningMouth(true);
    cancerSignAndSymptoms.setFoulSmellingVaginalDischarge(true);
    cancerSignAndSymptoms.setID(1L);
    cancerSignAndSymptoms.setLastModDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setLumpInTheBreast(true);
    cancerSignAndSymptoms.setLymphNode_Enlarged(true);
    cancerSignAndSymptoms.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerSignAndSymptoms.setNonHealingUlcerOrPatchOrGrowth(true);
    cancerSignAndSymptoms.setObservation("Observation");
    cancerSignAndSymptoms.setParkingPlaceID(1);
    cancerSignAndSymptoms.setProcessed("Processed");
    cancerSignAndSymptoms.setProviderServiceMapID(1);
    cancerSignAndSymptoms.setReservedForChange("Reserved For Change");
    cancerSignAndSymptoms.setShortnessOfBreath(true);
    cancerSignAndSymptoms.setSyncedBy("Synced By");
    cancerSignAndSymptoms.setSyncedDate(mock(Timestamp.class));
    cancerSignAndSymptoms.setVaginalBleedingAfterIntercourse(true);
    cancerSignAndSymptoms.setVaginalBleedingAfterMenopause(true);
    cancerSignAndSymptoms.setVaginalBleedingBetweenPeriods(true);
    cancerSignAndSymptoms.setVanID(1);
    cancerSignAndSymptoms.setVanSerialNo(1L);
    cancerSignAndSymptoms.setVehicalNo("Vehical No");
    cancerSignAndSymptoms.setVisitCode(1L);
    when(cancerSignAndSymptomsRepo.save(Mockito.<CancerSignAndSymptoms>any())).thenReturn(cancerSignAndSymptoms);

    CancerSignAndSymptoms cancerSignAndSymptoms2 = new CancerSignAndSymptoms();
    cancerSignAndSymptoms2.setBenVisitID(1L);
    cancerSignAndSymptoms2.setBeneficiaryRegID(1L);
    cancerSignAndSymptoms2.setBloodInSputum(true);
    cancerSignAndSymptoms2.setBloodStainedDischargeFromNipple(true);
    cancerSignAndSymptoms2.setBreastEnlargement(true);
    cancerSignAndSymptoms2.setBriefHistory("Observation");
    cancerSignAndSymptoms2.setChangeInShapeAndSizeOfBreasts(true);
    cancerSignAndSymptoms2.setChangeInTheToneOfVoice(true);
    cancerSignAndSymptoms2.setCoughGTE2Weeks(true);
    cancerSignAndSymptoms2.setCoughgt2Weeks(true);
    cancerSignAndSymptoms2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerSignAndSymptoms2.setCreatedDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setDeleted(true);
    cancerSignAndSymptoms2.setDifficultyInOpeningMouth(true);
    cancerSignAndSymptoms2.setFoulSmellingVaginalDischarge(true);
    cancerSignAndSymptoms2.setID(1L);
    cancerSignAndSymptoms2.setLastModDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setLumpInTheBreast(true);
    cancerSignAndSymptoms2.setLymphNode_Enlarged(true);
    cancerSignAndSymptoms2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerSignAndSymptoms2.setNonHealingUlcerOrPatchOrGrowth(true);
    cancerSignAndSymptoms2.setObservation("Observation");
    cancerSignAndSymptoms2.setParkingPlaceID(1);
    cancerSignAndSymptoms2.setProcessed("Processed");
    cancerSignAndSymptoms2.setProviderServiceMapID(1);
    cancerSignAndSymptoms2.setReservedForChange("Reserved For Change");
    cancerSignAndSymptoms2.setShortnessOfBreath(true);
    cancerSignAndSymptoms2.setSyncedBy("Synced By");
    cancerSignAndSymptoms2.setSyncedDate(mock(Timestamp.class));
    cancerSignAndSymptoms2.setVaginalBleedingAfterIntercourse(true);
    cancerSignAndSymptoms2.setVaginalBleedingAfterMenopause(true);
    cancerSignAndSymptoms2.setVaginalBleedingBetweenPeriods(true);
    cancerSignAndSymptoms2.setVanID(1);
    cancerSignAndSymptoms2.setVanSerialNo(1L);
    cancerSignAndSymptoms2.setVehicalNo("Vehical No");
    cancerSignAndSymptoms2.setVisitCode(1L);

    // Act
    Long actualSaveCancerSignAndSymptomsDataResult = cSNurseServiceImpl
        .saveCancerSignAndSymptomsData(cancerSignAndSymptoms2, 1L, 1L);

    // Assert
    verify(cancerSignAndSymptomsRepo).save(Mockito.<CancerSignAndSymptoms>any());
    assertEquals(1L, cancerSignAndSymptoms2.getBenVisitID().longValue());
    assertEquals(1L, cancerSignAndSymptoms2.getVisitCode().longValue());
    assertEquals(1L, actualSaveCancerSignAndSymptomsDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerOralExaminationData(CancerOralExamination)}
   */
  @Test
  void testSaveCancerOralExaminationData() {
    // Arrange
    CancerOralExamination cancerOralExamination = new CancerOralExamination();
    cancerOralExamination.setBenVisitID(1L);
    cancerOralExamination.setBeneficiaryRegID(1L);
    cancerOralExamination.setChronicBurningSensation(true);
    cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination.setDeleted(true);
    cancerOralExamination.setID(1L);
    cancerOralExamination.setLastModDate(mock(Timestamp.class));
    cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination.setObservation("Observation");
    cancerOralExamination.setParkingPlaceID(1);
    cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
    cancerOralExamination.setPremalignantLesions(true);
    cancerOralExamination.setProcessed("Processed");
    cancerOralExamination.setProlongedIrritation(true);
    cancerOralExamination.setProviderServiceMapID(1);
    cancerOralExamination.setReservedForChange("Reserved For Change");
    cancerOralExamination.setSyncedBy("Synced By");
    cancerOralExamination.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination.setVanID(1);
    cancerOralExamination.setVanSerialNo(1L);
    cancerOralExamination.setVehicalNo("Vehical No");
    cancerOralExamination.setVisitCode(1L);
    when(cancerOralExaminationRepo.save(Mockito.<CancerOralExamination>any())).thenReturn(cancerOralExamination);

    CancerOralExamination cancerOralExamination2 = new CancerOralExamination();
    cancerOralExamination2.setBenVisitID(1L);
    cancerOralExamination2.setBeneficiaryRegID(1L);
    cancerOralExamination2.setChronicBurningSensation(true);
    cancerOralExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination2.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination2.setDeleted(true);
    cancerOralExamination2.setID(1L);
    cancerOralExamination2.setLastModDate(mock(Timestamp.class));
    cancerOralExamination2.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination2.setObservation("Observation");
    cancerOralExamination2.setParkingPlaceID(1);
    cancerOralExamination2.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination2.setPreMalignantLesionTypeList(new ArrayList<>());
    cancerOralExamination2.setPremalignantLesions(true);
    cancerOralExamination2.setProcessed("Processed");
    cancerOralExamination2.setProlongedIrritation(true);
    cancerOralExamination2.setProviderServiceMapID(1);
    cancerOralExamination2.setReservedForChange("Reserved For Change");
    cancerOralExamination2.setSyncedBy("Synced By");
    cancerOralExamination2.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination2.setVanID(1);
    cancerOralExamination2.setVanSerialNo(1L);
    cancerOralExamination2.setVehicalNo("Vehical No");
    cancerOralExamination2.setVisitCode(1L);

    // Act
    Long actualSaveCancerOralExaminationDataResult = cSNurseServiceImpl
        .saveCancerOralExaminationData(cancerOralExamination2);

    // Assert
    verify(cancerOralExaminationRepo).save(Mockito.<CancerOralExamination>any());
    assertEquals("", cancerOralExamination2.getPreMalignantLesionType());
    assertEquals(1L, actualSaveCancerOralExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerOralExaminationData(CancerOralExamination)}
   */
  @Test
  void testSaveCancerOralExaminationData2() {
    // Arrange
    CancerOralExamination cancerOralExamination = new CancerOralExamination();
    cancerOralExamination.setBenVisitID(1L);
    cancerOralExamination.setBeneficiaryRegID(1L);
    cancerOralExamination.setChronicBurningSensation(true);
    cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination.setDeleted(true);
    cancerOralExamination.setID(1L);
    cancerOralExamination.setLastModDate(mock(Timestamp.class));
    cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination.setObservation("Observation");
    cancerOralExamination.setParkingPlaceID(1);
    cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
    cancerOralExamination.setPremalignantLesions(true);
    cancerOralExamination.setProcessed("Processed");
    cancerOralExamination.setProlongedIrritation(true);
    cancerOralExamination.setProviderServiceMapID(1);
    cancerOralExamination.setReservedForChange("Reserved For Change");
    cancerOralExamination.setSyncedBy("Synced By");
    cancerOralExamination.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination.setVanID(1);
    cancerOralExamination.setVanSerialNo(1L);
    cancerOralExamination.setVehicalNo("Vehical No");
    cancerOralExamination.setVisitCode(1L);
    when(cancerOralExaminationRepo.save(Mockito.<CancerOralExamination>any())).thenReturn(cancerOralExamination);

    ArrayList<String> preMalignantLesionTypeList = new ArrayList<>();
    preMalignantLesionTypeList.add("foo");

    CancerOralExamination cancerOralExamination2 = new CancerOralExamination();
    cancerOralExamination2.setBenVisitID(1L);
    cancerOralExamination2.setBeneficiaryRegID(1L);
    cancerOralExamination2.setChronicBurningSensation(true);
    cancerOralExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination2.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination2.setDeleted(true);
    cancerOralExamination2.setID(1L);
    cancerOralExamination2.setLastModDate(mock(Timestamp.class));
    cancerOralExamination2.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination2.setObservation("Observation");
    cancerOralExamination2.setParkingPlaceID(1);
    cancerOralExamination2.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination2.setPreMalignantLesionTypeList(preMalignantLesionTypeList);
    cancerOralExamination2.setPremalignantLesions(true);
    cancerOralExamination2.setProcessed("Processed");
    cancerOralExamination2.setProlongedIrritation(true);
    cancerOralExamination2.setProviderServiceMapID(1);
    cancerOralExamination2.setReservedForChange("Reserved For Change");
    cancerOralExamination2.setSyncedBy("Synced By");
    cancerOralExamination2.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination2.setVanID(1);
    cancerOralExamination2.setVanSerialNo(1L);
    cancerOralExamination2.setVehicalNo("Vehical No");
    cancerOralExamination2.setVisitCode(1L);

    // Act
    Long actualSaveCancerOralExaminationDataResult = cSNurseServiceImpl
        .saveCancerOralExaminationData(cancerOralExamination2);

    // Assert
    verify(cancerOralExaminationRepo).save(Mockito.<CancerOralExamination>any());
    assertEquals("foo,", cancerOralExamination2.getPreMalignantLesionType());
    assertEquals(1L, actualSaveCancerOralExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerOralExaminationDetails(CancerOralExamination)}
   */
  @Test
  void testGetCancerOralExaminationDetails() {
    // Arrange
    CancerOralExamination cancerOralExamination = new CancerOralExamination();
    cancerOralExamination.setBenVisitID(1L);
    cancerOralExamination.setBeneficiaryRegID(1L);
    cancerOralExamination.setChronicBurningSensation(true);
    cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination.setDeleted(true);
    cancerOralExamination.setID(1L);
    cancerOralExamination.setLastModDate(mock(Timestamp.class));
    cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination.setObservation("Observation");
    cancerOralExamination.setParkingPlaceID(1);
    cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
    cancerOralExamination.setPremalignantLesions(true);
    cancerOralExamination.setProcessed("Processed");
    cancerOralExamination.setProlongedIrritation(true);
    cancerOralExamination.setProviderServiceMapID(1);
    cancerOralExamination.setReservedForChange("Reserved For Change");
    cancerOralExamination.setSyncedBy("Synced By");
    cancerOralExamination.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination.setVanID(1);
    cancerOralExamination.setVanSerialNo(1L);
    cancerOralExamination.setVehicalNo("Vehical No");
    cancerOralExamination.setVisitCode(1L);

    // Act
    CancerOralExamination actualCancerOralExaminationDetails = cSNurseServiceImpl
        .getCancerOralExaminationDetails(cancerOralExamination);

    // Assert
    assertEquals("", actualCancerOralExaminationDetails.getPreMalignantLesionType());
    assertSame(cancerOralExamination, actualCancerOralExaminationDetails);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerOralExaminationDetails(CancerOralExamination)}
   */
  @Test
  void testGetCancerOralExaminationDetails2() {
    // Arrange
    ArrayList<String> preMalignantLesionTypeList = new ArrayList<>();
    preMalignantLesionTypeList.add("foo");

    CancerOralExamination cancerOralExamination = new CancerOralExamination();
    cancerOralExamination.setBenVisitID(1L);
    cancerOralExamination.setBeneficiaryRegID(1L);
    cancerOralExamination.setChronicBurningSensation(true);
    cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerOralExamination.setCreatedDate(mock(Timestamp.class));
    cancerOralExamination.setDeleted(true);
    cancerOralExamination.setID(1L);
    cancerOralExamination.setLastModDate(mock(Timestamp.class));
    cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
    cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerOralExamination.setObservation("Observation");
    cancerOralExamination.setParkingPlaceID(1);
    cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
    cancerOralExamination.setPreMalignantLesionTypeList(preMalignantLesionTypeList);
    cancerOralExamination.setPremalignantLesions(true);
    cancerOralExamination.setProcessed("Processed");
    cancerOralExamination.setProlongedIrritation(true);
    cancerOralExamination.setProviderServiceMapID(1);
    cancerOralExamination.setReservedForChange("Reserved For Change");
    cancerOralExamination.setSyncedBy("Synced By");
    cancerOralExamination.setSyncedDate(mock(Timestamp.class));
    cancerOralExamination.setVanID(1);
    cancerOralExamination.setVanSerialNo(1L);
    cancerOralExamination.setVehicalNo("Vehical No");
    cancerOralExamination.setVisitCode(1L);

    // Act
    CancerOralExamination actualCancerOralExaminationDetails = cSNurseServiceImpl
        .getCancerOralExaminationDetails(cancerOralExamination);

    // Assert
    assertEquals("foo,", actualCancerOralExaminationDetails.getPreMalignantLesionType());
    assertSame(cancerOralExamination, actualCancerOralExaminationDetails);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerBreastExaminationData(CancerBreastExamination)}
   */
  @Test
  void testSaveCancerBreastExaminationData() {
    // Arrange
    CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
    cancerBreastExamination.setBenVisitID(1L);
    cancerBreastExamination.setBeneficiaryRegID(1L);
    cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination.setBreastsAppear_Normal(true);
    cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination.setDeleted(true);
    cancerBreastExamination.setDimplingSkinOnBreast(true);
    cancerBreastExamination.setDischargeFromNipple(true);
    cancerBreastExamination.setEverBreastFed(true);
    cancerBreastExamination.setID(1L);
    cancerBreastExamination.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination.setLumpInBreast(true);
    cancerBreastExamination.setLumpShape("Lump Shape");
    cancerBreastExamination.setLumpSize("Lump Size");
    cancerBreastExamination.setLumpTexture("Lump Texture");
    cancerBreastExamination.setMamogramReport("Mamogram Report");
    cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination.setParkingPlaceID(1);
    cancerBreastExamination.setPeaudOrange(true);
    cancerBreastExamination.setProcessed("Processed");
    cancerBreastExamination.setProviderServiceMapID(1);
    cancerBreastExamination.setRashOnBreast(true);
    cancerBreastExamination.setReferredToMammogram(true);
    cancerBreastExamination.setReservedForChange("Reserved For Change");
    cancerBreastExamination.setSyncedBy("Synced By");
    cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination.setVanID(1);
    cancerBreastExamination.setVanSerialNo(1L);
    cancerBreastExamination.setVehicalNo("Vehical No");
    cancerBreastExamination.setVisitCode(1L);
    when(cancerBreastExaminationRepo.save(Mockito.<CancerBreastExamination>any())).thenReturn(cancerBreastExamination);

    CancerBreastExamination cancerBreastExamination2 = new CancerBreastExamination();
    cancerBreastExamination2.setBenVisitID(1L);
    cancerBreastExamination2.setBeneficiaryRegID(1L);
    cancerBreastExamination2.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination2.setBreastsAppear_Normal(true);
    cancerBreastExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination2.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination2.setDeleted(true);
    cancerBreastExamination2.setDimplingSkinOnBreast(true);
    cancerBreastExamination2.setDischargeFromNipple(true);
    cancerBreastExamination2.setEverBreastFed(true);
    cancerBreastExamination2.setID(1L);
    cancerBreastExamination2.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination2.setLumpInBreast(true);
    cancerBreastExamination2.setLumpShape("Lump Shape");
    cancerBreastExamination2.setLumpSize("Lump Size");
    cancerBreastExamination2.setLumpTexture("Lump Texture");
    cancerBreastExamination2.setMamogramReport("Mamogram Report");
    cancerBreastExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination2.setParkingPlaceID(1);
    cancerBreastExamination2.setPeaudOrange(true);
    cancerBreastExamination2.setProcessed("Processed");
    cancerBreastExamination2.setProviderServiceMapID(1);
    cancerBreastExamination2.setRashOnBreast(true);
    cancerBreastExamination2.setReferredToMammogram(true);
    cancerBreastExamination2.setReservedForChange("Reserved For Change");
    cancerBreastExamination2.setSyncedBy("Synced By");
    cancerBreastExamination2.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination2.setVanID(1);
    cancerBreastExamination2.setVanSerialNo(1L);
    cancerBreastExamination2.setVehicalNo("Vehical No");
    cancerBreastExamination2.setVisitCode(1L);

    // Act
    Long actualSaveCancerBreastExaminationDataResult = cSNurseServiceImpl
        .saveCancerBreastExaminationData(cancerBreastExamination2);

    // Assert
    verify(cancerBreastExaminationRepo).save(Mockito.<CancerBreastExamination>any());
    assertEquals(1L, actualSaveCancerBreastExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerAbdominalExaminationData(CancerAbdominalExamination)}
   */
  @Test
  void testSaveCancerAbdominalExaminationData() {
    // Arrange
    CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
    cancerAbdominalExamination.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination.setAnyOtherMass_Present(true);
    cancerAbdominalExamination.setAscites_Present(true);
    cancerAbdominalExamination.setBenVisitID(1L);
    cancerAbdominalExamination.setBeneficiaryRegID(1L);
    cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setDeleted(true);
    cancerAbdominalExamination.setID(1L);
    cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination.setLiver("Liver");
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination.setObservation("Observation");
    cancerAbdominalExamination.setParkingPlaceID(1);
    cancerAbdominalExamination.setProcessed("Processed");
    cancerAbdominalExamination.setProviderServiceMapID(1);
    cancerAbdominalExamination.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination.setSyncedBy("Synced By");
    cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setVanID(1);
    cancerAbdominalExamination.setVanSerialNo(1L);
    cancerAbdominalExamination.setVehicalNo("Vehical No");
    cancerAbdominalExamination.setVisitCode(1L);
    when(cancerAbdominalExaminationRepo.save(Mockito.<CancerAbdominalExamination>any()))
        .thenReturn(cancerAbdominalExamination);

    CancerAbdominalExamination cancerAbdominalExamination2 = new CancerAbdominalExamination();
    cancerAbdominalExamination2.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination2.setAnyOtherMass_Present(true);
    cancerAbdominalExamination2.setAscites_Present(true);
    cancerAbdominalExamination2.setBenVisitID(1L);
    cancerAbdominalExamination2.setBeneficiaryRegID(1L);
    cancerAbdominalExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination2.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination2.setDeleted(true);
    cancerAbdominalExamination2.setID(1L);
    cancerAbdominalExamination2.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination2.setLiver("Liver");
    cancerAbdominalExamination2.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination2.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination2.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination2.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination2.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination2.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination2.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination2.setObservation("Observation");
    cancerAbdominalExamination2.setParkingPlaceID(1);
    cancerAbdominalExamination2.setProcessed("Processed");
    cancerAbdominalExamination2.setProviderServiceMapID(1);
    cancerAbdominalExamination2.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination2.setSyncedBy("Synced By");
    cancerAbdominalExamination2.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination2.setVanID(1);
    cancerAbdominalExamination2.setVanSerialNo(1L);
    cancerAbdominalExamination2.setVehicalNo("Vehical No");
    cancerAbdominalExamination2.setVisitCode(1L);

    // Act
    Long actualSaveCancerAbdominalExaminationDataResult = cSNurseServiceImpl
        .saveCancerAbdominalExaminationData(cancerAbdominalExamination2);

    // Assert
    verify(cancerAbdominalExaminationRepo).save(Mockito.<CancerAbdominalExamination>any());
    assertEquals(1L, actualSaveCancerAbdominalExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerGynecologicalExaminationData(CancerGynecologicalExamination)}
   */
  @Test
  void testSaveCancerGynecologicalExaminationData() {
    // Arrange
    CancerGynecologicalExamination cancerGynecologicalExamination = new CancerGynecologicalExamination();
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");
    when(cancerGynecologicalExaminationRepo.save(Mockito.<CancerGynecologicalExamination>any()))
        .thenReturn(cancerGynecologicalExamination);

    CancerGynecologicalExamination cancerGynecologicalExamination2 = new CancerGynecologicalExamination();
    cancerGynecologicalExamination2.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination2.setBenVisitID(1L);
    cancerGynecologicalExamination2.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination2.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setDeleted(true);
    cancerGynecologicalExamination2.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination2.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination2.setID(1L);
    cancerGynecologicalExamination2.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination2.setObservation("Observation");
    cancerGynecologicalExamination2.setParkingPlaceID(1);
    cancerGynecologicalExamination2.setProcessed("Processed");
    cancerGynecologicalExamination2.setProviderServiceMapID(1);
    cancerGynecologicalExamination2.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination2.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination2.setSyncedBy("Synced By");
    cancerGynecologicalExamination2.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination2.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination2.setUterus_Normal(true);
    cancerGynecologicalExamination2.setVaginalInvolvement(true);
    cancerGynecologicalExamination2.setVanID(1);
    cancerGynecologicalExamination2.setVanSerialNo(1L);
    cancerGynecologicalExamination2.setVehicalNo("Vehical No");
    cancerGynecologicalExamination2.setVisitCode(1L);
    cancerGynecologicalExamination2.setVulvalInvolvement(true);
    cancerGynecologicalExamination2.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    Long actualSaveCancerGynecologicalExaminationDataResult = cSNurseServiceImpl
        .saveCancerGynecologicalExaminationData(cancerGynecologicalExamination2);

    // Assert
    verify(cancerGynecologicalExaminationRepo).save(Mockito.<CancerGynecologicalExamination>any());
    assertEquals("", cancerGynecologicalExamination2.getTypeOfLesion());
    assertEquals(1L, actualSaveCancerGynecologicalExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerGynecologicalExaminationData(CancerGynecologicalExamination)}
   */
  @Test
  void testSaveCancerGynecologicalExaminationData2() {
    // Arrange
    CancerGynecologicalExamination cancerGynecologicalExamination = mock(CancerGynecologicalExamination.class);
    when(cancerGynecologicalExamination.getID()).thenReturn(1L);
    doNothing().when(cancerGynecologicalExamination).setAppearanceOfCervix(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setFilePath(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setObservation(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setProcessed(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesion(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    doNothing().when(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setrTIOrSTIDetail(Mockito.<String>any());
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");
    when(cancerGynecologicalExaminationRepo.save(Mockito.<CancerGynecologicalExamination>any()))
        .thenReturn(cancerGynecologicalExamination);

    CancerGynecologicalExamination cancerGynecologicalExamination2 = new CancerGynecologicalExamination();
    cancerGynecologicalExamination2.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination2.setBenVisitID(1L);
    cancerGynecologicalExamination2.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination2.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setDeleted(true);
    cancerGynecologicalExamination2.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination2.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination2.setID(1L);
    cancerGynecologicalExamination2.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination2.setObservation("Observation");
    cancerGynecologicalExamination2.setParkingPlaceID(1);
    cancerGynecologicalExamination2.setProcessed("Processed");
    cancerGynecologicalExamination2.setProviderServiceMapID(1);
    cancerGynecologicalExamination2.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination2.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination2.setSyncedBy("Synced By");
    cancerGynecologicalExamination2.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination2.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination2.setUterus_Normal(true);
    cancerGynecologicalExamination2.setVaginalInvolvement(true);
    cancerGynecologicalExamination2.setVanID(1);
    cancerGynecologicalExamination2.setVanSerialNo(1L);
    cancerGynecologicalExamination2.setVehicalNo("Vehical No");
    cancerGynecologicalExamination2.setVisitCode(1L);
    cancerGynecologicalExamination2.setVulvalInvolvement(true);
    cancerGynecologicalExamination2.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    Long actualSaveCancerGynecologicalExaminationDataResult = cSNurseServiceImpl
        .saveCancerGynecologicalExaminationData(cancerGynecologicalExamination2);

    // Assert
    verify(cancerGynecologicalExamination).getID();
    verify(cancerGynecologicalExamination).setAppearanceOfCervix(eq("Appearance Of Cervix"));
    verify(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setFilePath(eq("/directory/foo.txt"));
    verify(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setObservation(eq("Observation"));
    verify(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setProcessed(eq("Processed"));
    verify(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setReservedForChange(eq("Reserved For Change"));
    verify(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setSyncedBy(eq("Synced By"));
    verify(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setTypeOfLesion(eq("Type Of Lesion"));
    verify(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    verify(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVehicalNo(eq("Vehical No"));
    verify(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setrTIOrSTIDetail(eq("R TIOr STIDetail"));
    verify(cancerGynecologicalExaminationRepo).save(Mockito.<CancerGynecologicalExamination>any());
    assertEquals("", cancerGynecologicalExamination2.getTypeOfLesion());
    assertEquals(1L, actualSaveCancerGynecologicalExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveCancerGynecologicalExaminationData(CancerGynecologicalExamination)}
   */
  @Test
  void testSaveCancerGynecologicalExaminationData3() {
    // Arrange
    CancerGynecologicalExamination cancerGynecologicalExamination = mock(CancerGynecologicalExamination.class);
    when(cancerGynecologicalExamination.getID()).thenReturn(1L);
    doNothing().when(cancerGynecologicalExamination).setAppearanceOfCervix(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setFilePath(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setObservation(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setProcessed(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesion(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    doNothing().when(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setrTIOrSTIDetail(Mockito.<String>any());
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");
    when(cancerGynecologicalExaminationRepo.save(Mockito.<CancerGynecologicalExamination>any()))
        .thenReturn(cancerGynecologicalExamination);
    CancerGynecologicalExamination cancerGynecologicalExamination2 = mock(CancerGynecologicalExamination.class);
    when(cancerGynecologicalExamination2.getTypeOfLesionList()).thenReturn(new ArrayList<>());
    doNothing().when(cancerGynecologicalExamination2).setAppearanceOfCervix(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination2).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination2).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination2).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setFilePath(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination2).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination2).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setObservation(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination2).setProcessed(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination2).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination2).setTypeOfLesion(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setTypeOfLesionList(Mockito.<List<String>>any());
    doNothing().when(cancerGynecologicalExamination2).setUterus_Normal(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setVaginalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination2).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination2).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination2).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination2).setVulvalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination2).setrTIOrSTIDetail(Mockito.<String>any());
    cancerGynecologicalExamination2.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination2.setBenVisitID(1L);
    cancerGynecologicalExamination2.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination2.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setDeleted(true);
    cancerGynecologicalExamination2.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination2.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination2.setID(1L);
    cancerGynecologicalExamination2.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination2.setObservation("Observation");
    cancerGynecologicalExamination2.setParkingPlaceID(1);
    cancerGynecologicalExamination2.setProcessed("Processed");
    cancerGynecologicalExamination2.setProviderServiceMapID(1);
    cancerGynecologicalExamination2.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination2.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination2.setSyncedBy("Synced By");
    cancerGynecologicalExamination2.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination2.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination2.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination2.setUterus_Normal(true);
    cancerGynecologicalExamination2.setVaginalInvolvement(true);
    cancerGynecologicalExamination2.setVanID(1);
    cancerGynecologicalExamination2.setVanSerialNo(1L);
    cancerGynecologicalExamination2.setVehicalNo("Vehical No");
    cancerGynecologicalExamination2.setVisitCode(1L);
    cancerGynecologicalExamination2.setVulvalInvolvement(true);
    cancerGynecologicalExamination2.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    Long actualSaveCancerGynecologicalExaminationDataResult = cSNurseServiceImpl
        .saveCancerGynecologicalExaminationData(cancerGynecologicalExamination2);

    // Assert
    verify(cancerGynecologicalExamination).getID();
    verify(cancerGynecologicalExamination2).getTypeOfLesionList();
    verify(cancerGynecologicalExamination).setAppearanceOfCervix(eq("Appearance Of Cervix"));
    verify(cancerGynecologicalExamination2).setAppearanceOfCervix(eq("Appearance Of Cervix"));
    verify(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination2).setBenVisitID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination2).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerGynecologicalExamination2).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination2).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setDeleted(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setFilePath(eq("/directory/foo.txt"));
    verify(cancerGynecologicalExamination2).setFilePath(eq("/directory/foo.txt"));
    verify(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination2).setID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination2).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerGynecologicalExamination2).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setObservation(eq("Observation"));
    verify(cancerGynecologicalExamination2).setObservation(eq("Observation"));
    verify(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination2).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setProcessed(eq("Processed"));
    verify(cancerGynecologicalExamination2).setProcessed(eq("Processed"));
    verify(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination2).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setReservedForChange(eq("Reserved For Change"));
    verify(cancerGynecologicalExamination2).setReservedForChange(eq("Reserved For Change"));
    verify(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setSyncedBy(eq("Synced By"));
    verify(cancerGynecologicalExamination2).setSyncedBy(eq("Synced By"));
    verify(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination2).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination2, atLeast(1)).setTypeOfLesion(Mockito.<String>any());
    verify(cancerGynecologicalExamination).setTypeOfLesion(eq("Type Of Lesion"));
    verify(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    verify(cancerGynecologicalExamination2).setTypeOfLesionList(Mockito.<List<String>>any());
    verify(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setUterus_Normal(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setVaginalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination2).setVanID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    verify(cancerGynecologicalExamination2).setVanSerialNo(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVehicalNo(eq("Vehical No"));
    verify(cancerGynecologicalExamination2).setVehicalNo(eq("Vehical No"));
    verify(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    verify(cancerGynecologicalExamination2).setVisitCode(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination2).setVulvalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setrTIOrSTIDetail(eq("R TIOr STIDetail"));
    verify(cancerGynecologicalExamination2).setrTIOrSTIDetail(eq("R TIOr STIDetail"));
    verify(cancerGynecologicalExaminationRepo).save(Mockito.<CancerGynecologicalExamination>any());
    assertEquals(1L, actualSaveCancerGynecologicalExaminationDataResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveDocExaminationImageAnnotation(List, Long, Long)}
   */
  @Test
  void testSaveDocExaminationImageAnnotation() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Long actualSaveDocExaminationImageAnnotationResult = cSNurseServiceImpl
        .saveDocExaminationImageAnnotation(new ArrayList<>(), 1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertNull(actualSaveDocExaminationImageAnnotationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveDocExaminationImageAnnotation(List, Long, Long)}
   */
  @Test
  void testSaveDocExaminationImageAnnotation2() {
    // Arrange
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(cancerExaminationImageAnnotationList);

    // Act
    Long actualSaveDocExaminationImageAnnotationResult = cSNurseServiceImpl
        .saveDocExaminationImageAnnotation(new ArrayList<>(), 1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(1L, actualSaveDocExaminationImageAnnotationResult.longValue());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveDocExaminationImageAnnotation(List, Long, Long)}
   */
  @Test
  void testSaveDocExaminationImageAnnotation3() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());

    // Act
    Long actualSaveDocExaminationImageAnnotationResult = cSNurseServiceImpl
        .saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList, 1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertNull(actualSaveDocExaminationImageAnnotationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveDocExaminationImageAnnotation(List, Long, Long)}
   */
  @Test
  void testSaveDocExaminationImageAnnotation4() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());

    // Act
    Long actualSaveDocExaminationImageAnnotationResult = cSNurseServiceImpl
        .saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList, 1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertNull(actualSaveDocExaminationImageAnnotationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#saveDocExaminationImageAnnotation(List, Long, Long)}
   */
  @Test
  void testSaveDocExaminationImageAnnotation5() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList
        .add(new WrapperCancerExamImgAnotasn(1L, 1L, 1, 1, new ArrayList<>(), "Jan 1, 2020 8:00am GMT+0100"));

    // Act
    Long actualSaveDocExaminationImageAnnotationResult = cSNurseServiceImpl
        .saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList, 1L, 1L);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertNull(actualSaveDocExaminationImageAnnotationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList() {
    // Arrange, Act and Assert
    assertTrue(cSNurseServiceImpl.getCancerExaminationImageAnnotationList(new ArrayList<>(), 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList2() {
    // Arrange
    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());

    // Act and Assert
    assertTrue(
        cSNurseServiceImpl.getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList, 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList3() {
    // Arrange
    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
    wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());

    // Act and Assert
    assertTrue(
        cSNurseServiceImpl.getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList, 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList4() {
    // Arrange
    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(null);

    // Act and Assert
    assertTrue(
        cSNurseServiceImpl.getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList, 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList5() {
    // Arrange
    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList
        .add(new WrapperCancerExamImgAnotasn(1L, 1L, 1, 1, new ArrayList<>(), "Jan 1, 2020 8:00am GMT+0100"));

    // Act and Assert
    assertTrue(
        cSNurseServiceImpl.getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList, 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#getCancerExaminationImageAnnotationList(List, Long)}
   */
  @Test
  void testGetCancerExaminationImageAnnotationList6() {
    // Arrange
    WrapperCancerExamImgAnotasn wrapperCancerExamImgAnotasn = mock(WrapperCancerExamImgAnotasn.class);
    when(wrapperCancerExamImgAnotasn.getMarkers()).thenReturn(new ArrayList<>());

    ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
    wrapperCancerExamImgAnotasnList.add(wrapperCancerExamImgAnotasn);

    // Act
    List<CancerExaminationImageAnnotation> actualCancerExaminationImageAnnotationList = cSNurseServiceImpl
        .getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList, 1L);

    // Assert
    verify(wrapperCancerExamImgAnotasn).getMarkers();
    assertTrue(actualCancerExaminationImageAnnotationList.isEmpty());
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerBreastDetails(CancerBreastExamination)}
   */
  @Test
  void testUpdateCancerBreastDetails() {
    // Arrange
    when(cancerBreastExaminationRepo.updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(cancerBreastExaminationRepo.getCancerBreastExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Cancer Breast Examination Status");

    CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
    cancerBreastExamination.setBenVisitID(1L);
    cancerBreastExamination.setBeneficiaryRegID(1L);
    cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination.setBreastsAppear_Normal(true);
    cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination.setDeleted(true);
    cancerBreastExamination.setDimplingSkinOnBreast(true);
    cancerBreastExamination.setDischargeFromNipple(true);
    cancerBreastExamination.setEverBreastFed(true);
    cancerBreastExamination.setID(1L);
    cancerBreastExamination.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination.setLumpInBreast(true);
    cancerBreastExamination.setLumpShape("Lump Shape");
    cancerBreastExamination.setLumpSize("Lump Size");
    cancerBreastExamination.setLumpTexture("Lump Texture");
    cancerBreastExamination.setMamogramReport("Mamogram Report");
    cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination.setParkingPlaceID(1);
    cancerBreastExamination.setPeaudOrange(true);
    cancerBreastExamination.setProcessed("Processed");
    cancerBreastExamination.setProviderServiceMapID(1);
    cancerBreastExamination.setRashOnBreast(true);
    cancerBreastExamination.setReferredToMammogram(true);
    cancerBreastExamination.setReservedForChange("Reserved For Change");
    cancerBreastExamination.setSyncedBy("Synced By");
    cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination.setVanID(1);
    cancerBreastExamination.setVanSerialNo(1L);
    cancerBreastExamination.setVehicalNo("Vehical No");
    cancerBreastExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerBreastDetailsResult = cSNurseServiceImpl.updateCancerBreastDetails(cancerBreastExamination);

    // Assert
    verify(cancerBreastExaminationRepo).getCancerBreastExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(cancerBreastExaminationRepo).updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Lump Size"), eq("Lump Shape"),
        eq("Lump Texture"), Mockito.<Boolean>any(), eq("Mamogram Report"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("U"));
    assertEquals("U", cancerBreastExamination.getProcessed());
    assertEquals(1, actualUpdateCancerBreastDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerBreastDetails(CancerBreastExamination)}
   */
  @Test
  void testUpdateCancerBreastDetails2() {
    // Arrange
    when(cancerBreastExaminationRepo.updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(cancerBreastExaminationRepo.getCancerBreastExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("N");

    CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
    cancerBreastExamination.setBenVisitID(1L);
    cancerBreastExamination.setBeneficiaryRegID(1L);
    cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination.setBreastsAppear_Normal(true);
    cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination.setDeleted(true);
    cancerBreastExamination.setDimplingSkinOnBreast(true);
    cancerBreastExamination.setDischargeFromNipple(true);
    cancerBreastExamination.setEverBreastFed(true);
    cancerBreastExamination.setID(1L);
    cancerBreastExamination.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination.setLumpInBreast(true);
    cancerBreastExamination.setLumpShape("Lump Shape");
    cancerBreastExamination.setLumpSize("Lump Size");
    cancerBreastExamination.setLumpTexture("Lump Texture");
    cancerBreastExamination.setMamogramReport("Mamogram Report");
    cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination.setParkingPlaceID(1);
    cancerBreastExamination.setPeaudOrange(true);
    cancerBreastExamination.setProcessed("Processed");
    cancerBreastExamination.setProviderServiceMapID(1);
    cancerBreastExamination.setRashOnBreast(true);
    cancerBreastExamination.setReferredToMammogram(true);
    cancerBreastExamination.setReservedForChange("Reserved For Change");
    cancerBreastExamination.setSyncedBy("Synced By");
    cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination.setVanID(1);
    cancerBreastExamination.setVanSerialNo(1L);
    cancerBreastExamination.setVehicalNo("Vehical No");
    cancerBreastExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerBreastDetailsResult = cSNurseServiceImpl.updateCancerBreastDetails(cancerBreastExamination);

    // Assert
    verify(cancerBreastExaminationRepo).getCancerBreastExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any());
    verify(cancerBreastExaminationRepo).updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Lump Size"), eq("Lump Shape"),
        eq("Lump Texture"), Mockito.<Boolean>any(), eq("Mamogram Report"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("N"));
    assertEquals("N", cancerBreastExamination.getProcessed());
    assertEquals(1, actualUpdateCancerBreastDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerBreastExamination(CancerBreastExamination)}
   */
  @Test
  void testUpdateCancerBreastExamination() {
    // Arrange
    when(cancerBreastExaminationRepo.updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
    cancerBreastExamination.setBenVisitID(1L);
    cancerBreastExamination.setBeneficiaryRegID(1L);
    cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
    cancerBreastExamination.setBreastsAppear_Normal(true);
    cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
    cancerBreastExamination.setDeleted(true);
    cancerBreastExamination.setDimplingSkinOnBreast(true);
    cancerBreastExamination.setDischargeFromNipple(true);
    cancerBreastExamination.setEverBreastFed(true);
    cancerBreastExamination.setID(1L);
    cancerBreastExamination.setLastModDate(mock(Timestamp.class));
    cancerBreastExamination.setLumpInBreast(true);
    cancerBreastExamination.setLumpShape("Lump Shape");
    cancerBreastExamination.setLumpSize("Lump Size");
    cancerBreastExamination.setLumpTexture("Lump Texture");
    cancerBreastExamination.setMamogramReport("Mamogram Report");
    cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerBreastExamination.setParkingPlaceID(1);
    cancerBreastExamination.setPeaudOrange(true);
    cancerBreastExamination.setProcessed("Processed");
    cancerBreastExamination.setProviderServiceMapID(1);
    cancerBreastExamination.setRashOnBreast(true);
    cancerBreastExamination.setReferredToMammogram(true);
    cancerBreastExamination.setReservedForChange("Reserved For Change");
    cancerBreastExamination.setSyncedBy("Synced By");
    cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
    cancerBreastExamination.setVanID(1);
    cancerBreastExamination.setVanSerialNo(1L);
    cancerBreastExamination.setVehicalNo("Vehical No");
    cancerBreastExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerBreastExaminationResult = cSNurseServiceImpl
        .updateCancerBreastExamination(cancerBreastExamination);

    // Assert
    verify(cancerBreastExaminationRepo).updateCancerBreastExaminatio(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Lump Size"), eq("Lump Shape"),
        eq("Lump Texture"), Mockito.<Boolean>any(), eq("Mamogram Report"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateCancerBreastExaminationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerAbdominalExaminationDetails(CancerAbdominalExamination)}
   */
  @Test
  void testUpdateCancerAbdominalExaminationDetails() {
    // Arrange
    when(cancerAbdominalExaminationRepo.updateCancerAbdominalExamination(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(cancerAbdominalExaminationRepo.getCancerAbdominalExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("Cancer Abdominal Examination Status");

    CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
    cancerAbdominalExamination.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination.setAnyOtherMass_Present(true);
    cancerAbdominalExamination.setAscites_Present(true);
    cancerAbdominalExamination.setBenVisitID(1L);
    cancerAbdominalExamination.setBeneficiaryRegID(1L);
    cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setDeleted(true);
    cancerAbdominalExamination.setID(1L);
    cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination.setLiver("Liver");
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination.setObservation("Observation");
    cancerAbdominalExamination.setParkingPlaceID(1);
    cancerAbdominalExamination.setProcessed("Processed");
    cancerAbdominalExamination.setProviderServiceMapID(1);
    cancerAbdominalExamination.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination.setSyncedBy("Synced By");
    cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setVanID(1);
    cancerAbdominalExamination.setVanSerialNo(1L);
    cancerAbdominalExamination.setVehicalNo("Vehical No");
    cancerAbdominalExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerAbdominalExaminationDetailsResult = cSNurseServiceImpl
        .updateCancerAbdominalExaminationDetails(cancerAbdominalExamination);

    // Assert
    verify(cancerAbdominalExaminationRepo).getCancerAbdominalExaminationStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(cancerAbdominalExaminationRepo).updateCancerAbdominalExamination(Mockito.<Integer>any(),
        Mockito.<Boolean>any(), eq("Liver"), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("U"));
    assertEquals("U", cancerAbdominalExamination.getProcessed());
    assertEquals(1, actualUpdateCancerAbdominalExaminationDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerAbdominalExaminationDetails(CancerAbdominalExamination)}
   */
  @Test
  void testUpdateCancerAbdominalExaminationDetails2() {
    // Arrange
    when(cancerAbdominalExaminationRepo.updateCancerAbdominalExamination(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(cancerAbdominalExaminationRepo.getCancerAbdominalExaminationStatus(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn("N");

    CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
    cancerAbdominalExamination.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination.setAnyOtherMass_Present(true);
    cancerAbdominalExamination.setAscites_Present(true);
    cancerAbdominalExamination.setBenVisitID(1L);
    cancerAbdominalExamination.setBeneficiaryRegID(1L);
    cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setDeleted(true);
    cancerAbdominalExamination.setID(1L);
    cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination.setLiver("Liver");
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination.setObservation("Observation");
    cancerAbdominalExamination.setParkingPlaceID(1);
    cancerAbdominalExamination.setProcessed("Processed");
    cancerAbdominalExamination.setProviderServiceMapID(1);
    cancerAbdominalExamination.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination.setSyncedBy("Synced By");
    cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setVanID(1);
    cancerAbdominalExamination.setVanSerialNo(1L);
    cancerAbdominalExamination.setVehicalNo("Vehical No");
    cancerAbdominalExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerAbdominalExaminationDetailsResult = cSNurseServiceImpl
        .updateCancerAbdominalExaminationDetails(cancerAbdominalExamination);

    // Assert
    verify(cancerAbdominalExaminationRepo).getCancerAbdominalExaminationStatus(Mockito.<Long>any(),
        Mockito.<Long>any());
    verify(cancerAbdominalExaminationRepo).updateCancerAbdominalExamination(Mockito.<Integer>any(),
        Mockito.<Boolean>any(), eq("Liver"), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("N"));
    assertEquals("N", cancerAbdominalExamination.getProcessed());
    assertEquals(1, actualUpdateCancerAbdominalExaminationDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerAbdominalExamination(CancerAbdominalExamination)}
   */
  @Test
  void testUpdateCancerAbdominalExamination() {
    // Arrange
    when(cancerAbdominalExaminationRepo.updateCancerAbdominalExamination(Mockito.<Integer>any(), Mockito.<Boolean>any(),
        Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
    cancerAbdominalExamination.setAbdominalInspection_Normal(true);
    cancerAbdominalExamination.setAnyOtherMass_Present(true);
    cancerAbdominalExamination.setAscites_Present(true);
    cancerAbdominalExamination.setBenVisitID(1L);
    cancerAbdominalExamination.setBeneficiaryRegID(1L);
    cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setDeleted(true);
    cancerAbdominalExamination.setID(1L);
    cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
    cancerAbdominalExamination.setLiver("Liver");
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
    cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
    cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
    cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
    cancerAbdominalExamination.setLymphNodes_Enlarged(true);
    cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerAbdominalExamination.setObservation("Observation");
    cancerAbdominalExamination.setParkingPlaceID(1);
    cancerAbdominalExamination.setProcessed("Processed");
    cancerAbdominalExamination.setProviderServiceMapID(1);
    cancerAbdominalExamination.setReservedForChange("Reserved For Change");
    cancerAbdominalExamination.setSyncedBy("Synced By");
    cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
    cancerAbdominalExamination.setVanID(1);
    cancerAbdominalExamination.setVanSerialNo(1L);
    cancerAbdominalExamination.setVehicalNo("Vehical No");
    cancerAbdominalExamination.setVisitCode(1L);

    // Act
    int actualUpdateCancerAbdominalExaminationResult = cSNurseServiceImpl
        .updateCancerAbdominalExamination(cancerAbdominalExamination);

    // Assert
    verify(cancerAbdominalExaminationRepo).updateCancerAbdominalExamination(Mockito.<Integer>any(),
        Mockito.<Boolean>any(), eq("Liver"), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"),
        Mockito.<Long>any(), Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateCancerAbdominalExaminationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerGynecologicalExamination(CancerGynecologicalExamination)}
   */
  @Test
  void testUpdateCancerGynecologicalExamination() {
    // Arrange
    when(cancerGynecologicalExaminationRepo.updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);

    CancerGynecologicalExamination cancerGynecologicalExamination = new CancerGynecologicalExamination();
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    int actualUpdateCancerGynecologicalExaminationResult = cSNurseServiceImpl
        .updateCancerGynecologicalExamination(cancerGynecologicalExamination);

    // Assert
    verify(cancerGynecologicalExaminationRepo).updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        eq("Appearance Of Cervix"), eq(""), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), eq("R TIOr STIDetail"), eq("/directory/foo.txt"), Mockito.<Boolean>any(),
        eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(), Mockito.<Long>any(),
        eq("Processed"));
    assertEquals("", cancerGynecologicalExamination.getTypeOfLesion());
    assertEquals(1, actualUpdateCancerGynecologicalExaminationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerGynecologicalExamination(CancerGynecologicalExamination)}
   */
  @Test
  void testUpdateCancerGynecologicalExamination2() {
    // Arrange
    when(cancerGynecologicalExaminationRepo.updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);
    CancerGynecologicalExamination cancerGynecologicalExamination = mock(CancerGynecologicalExamination.class);
    when(cancerGynecologicalExamination.getExperiencedPostCoitalBleeding()).thenReturn(true);
    when(cancerGynecologicalExamination.getSufferedFromRTIOrSTI()).thenReturn(true);
    when(cancerGynecologicalExamination.getUterus_Normal()).thenReturn(true);
    when(cancerGynecologicalExamination.getVaginalInvolvement()).thenReturn(true);
    when(cancerGynecologicalExamination.getVulvalInvolvement()).thenReturn(true);
    when(cancerGynecologicalExamination.getProviderServiceMapID()).thenReturn(1);
    when(cancerGynecologicalExamination.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerGynecologicalExamination.getVisitCode()).thenReturn(1L);
    when(cancerGynecologicalExamination.getAppearanceOfCervix()).thenReturn("Appearance Of Cervix");
    when(cancerGynecologicalExamination.getFilePath()).thenReturn("/directory/foo.txt");
    when(cancerGynecologicalExamination.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(cancerGynecologicalExamination.getObservation()).thenReturn("Observation");
    when(cancerGynecologicalExamination.getProcessed()).thenReturn("Processed");
    when(cancerGynecologicalExamination.getTypeOfLesion()).thenReturn("Type Of Lesion");
    when(cancerGynecologicalExamination.getrTIOrSTIDetail()).thenReturn("Getr TIOr STIDetail");
    when(cancerGynecologicalExamination.getTypeOfLesionList()).thenReturn(new ArrayList<>());
    doNothing().when(cancerGynecologicalExamination).setAppearanceOfCervix(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setFilePath(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setObservation(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setProcessed(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesion(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    doNothing().when(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setrTIOrSTIDetail(Mockito.<String>any());
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    int actualUpdateCancerGynecologicalExaminationResult = cSNurseServiceImpl
        .updateCancerGynecologicalExamination(cancerGynecologicalExamination);

    // Assert
    verify(cancerGynecologicalExamination).getAppearanceOfCervix();
    verify(cancerGynecologicalExamination).getBeneficiaryRegID();
    verify(cancerGynecologicalExamination).getExperiencedPostCoitalBleeding();
    verify(cancerGynecologicalExamination).getFilePath();
    verify(cancerGynecologicalExamination).getModifiedBy();
    verify(cancerGynecologicalExamination).getObservation();
    verify(cancerGynecologicalExamination).getProcessed();
    verify(cancerGynecologicalExamination).getProviderServiceMapID();
    verify(cancerGynecologicalExamination).getSufferedFromRTIOrSTI();
    verify(cancerGynecologicalExamination).getTypeOfLesion();
    verify(cancerGynecologicalExamination).getTypeOfLesionList();
    verify(cancerGynecologicalExamination).getUterus_Normal();
    verify(cancerGynecologicalExamination).getVaginalInvolvement();
    verify(cancerGynecologicalExamination).getVisitCode();
    verify(cancerGynecologicalExamination).getVulvalInvolvement();
    verify(cancerGynecologicalExamination).getrTIOrSTIDetail();
    verify(cancerGynecologicalExamination).setAppearanceOfCervix(eq("Appearance Of Cervix"));
    verify(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setFilePath(eq("/directory/foo.txt"));
    verify(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setObservation(eq("Observation"));
    verify(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setProcessed(eq("Processed"));
    verify(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setReservedForChange(eq("Reserved For Change"));
    verify(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setSyncedBy(eq("Synced By"));
    verify(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination, atLeast(1)).setTypeOfLesion(Mockito.<String>any());
    verify(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    verify(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVehicalNo(eq("Vehical No"));
    verify(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setrTIOrSTIDetail(eq("R TIOr STIDetail"));
    verify(cancerGynecologicalExaminationRepo).updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        eq("Appearance Of Cervix"), eq("Type Of Lesion"), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Getr TIOr STIDetail"), eq("/directory/foo.txt"),
        Mockito.<Boolean>any(), eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(),
        Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateCancerGynecologicalExaminationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerGynecologicalExamination(CancerGynecologicalExamination)}
   */
  @Test
  void testUpdateCancerGynecologicalExamination3() {
    // Arrange
    when(cancerGynecologicalExaminationRepo.updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<String>any())).thenReturn(1);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    CancerGynecologicalExamination cancerGynecologicalExamination = mock(CancerGynecologicalExamination.class);
    when(cancerGynecologicalExamination.getExperiencedPostCoitalBleeding()).thenReturn(true);
    when(cancerGynecologicalExamination.getSufferedFromRTIOrSTI()).thenReturn(true);
    when(cancerGynecologicalExamination.getUterus_Normal()).thenReturn(true);
    when(cancerGynecologicalExamination.getVaginalInvolvement()).thenReturn(true);
    when(cancerGynecologicalExamination.getVulvalInvolvement()).thenReturn(true);
    when(cancerGynecologicalExamination.getProviderServiceMapID()).thenReturn(1);
    when(cancerGynecologicalExamination.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerGynecologicalExamination.getVisitCode()).thenReturn(1L);
    when(cancerGynecologicalExamination.getAppearanceOfCervix()).thenReturn("Appearance Of Cervix");
    when(cancerGynecologicalExamination.getFilePath()).thenReturn("/directory/foo.txt");
    when(cancerGynecologicalExamination.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
    when(cancerGynecologicalExamination.getObservation()).thenReturn("Observation");
    when(cancerGynecologicalExamination.getProcessed()).thenReturn("Processed");
    when(cancerGynecologicalExamination.getTypeOfLesion()).thenReturn("Type Of Lesion");
    when(cancerGynecologicalExamination.getrTIOrSTIDetail()).thenReturn("Getr TIOr STIDetail");
    when(cancerGynecologicalExamination.getTypeOfLesionList()).thenReturn(stringList);
    doNothing().when(cancerGynecologicalExamination).setAppearanceOfCervix(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setFilePath(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setObservation(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setProcessed(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesion(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    doNothing().when(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    doNothing().when(cancerGynecologicalExamination).setrTIOrSTIDetail(Mockito.<String>any());
    cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
    cancerGynecologicalExamination.setBenVisitID(1L);
    cancerGynecologicalExamination.setBeneficiaryRegID(1L);
    cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setDeleted(true);
    cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
    cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
    cancerGynecologicalExamination.setID(1L);
    cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerGynecologicalExamination.setObservation("Observation");
    cancerGynecologicalExamination.setParkingPlaceID(1);
    cancerGynecologicalExamination.setProcessed("Processed");
    cancerGynecologicalExamination.setProviderServiceMapID(1);
    cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
    cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
    cancerGynecologicalExamination.setSyncedBy("Synced By");
    cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
    cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
    cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
    cancerGynecologicalExamination.setUterus_Normal(true);
    cancerGynecologicalExamination.setVaginalInvolvement(true);
    cancerGynecologicalExamination.setVanID(1);
    cancerGynecologicalExamination.setVanSerialNo(1L);
    cancerGynecologicalExamination.setVehicalNo("Vehical No");
    cancerGynecologicalExamination.setVisitCode(1L);
    cancerGynecologicalExamination.setVulvalInvolvement(true);
    cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");

    // Act
    int actualUpdateCancerGynecologicalExaminationResult = cSNurseServiceImpl
        .updateCancerGynecologicalExamination(cancerGynecologicalExamination);

    // Assert
    verify(cancerGynecologicalExamination).getAppearanceOfCervix();
    verify(cancerGynecologicalExamination).getBeneficiaryRegID();
    verify(cancerGynecologicalExamination).getExperiencedPostCoitalBleeding();
    verify(cancerGynecologicalExamination).getFilePath();
    verify(cancerGynecologicalExamination).getModifiedBy();
    verify(cancerGynecologicalExamination).getObservation();
    verify(cancerGynecologicalExamination).getProcessed();
    verify(cancerGynecologicalExamination).getProviderServiceMapID();
    verify(cancerGynecologicalExamination).getSufferedFromRTIOrSTI();
    verify(cancerGynecologicalExamination).getTypeOfLesion();
    verify(cancerGynecologicalExamination).getTypeOfLesionList();
    verify(cancerGynecologicalExamination).getUterus_Normal();
    verify(cancerGynecologicalExamination).getVaginalInvolvement();
    verify(cancerGynecologicalExamination).getVisitCode();
    verify(cancerGynecologicalExamination).getVulvalInvolvement();
    verify(cancerGynecologicalExamination).getrTIOrSTIDetail();
    verify(cancerGynecologicalExamination).setAppearanceOfCervix(eq("Appearance Of Cervix"));
    verify(cancerGynecologicalExamination).setBenVisitID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setDeleted(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setExperiencedPostCoitalBleeding(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setFilePath(eq("/directory/foo.txt"));
    verify(cancerGynecologicalExamination).setID(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerGynecologicalExamination).setObservation(eq("Observation"));
    verify(cancerGynecologicalExamination).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setProcessed(eq("Processed"));
    verify(cancerGynecologicalExamination).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setReservedForChange(eq("Reserved For Change"));
    verify(cancerGynecologicalExamination).setSufferedFromRTIOrSTI(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setSyncedBy(eq("Synced By"));
    verify(cancerGynecologicalExamination).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerGynecologicalExamination, atLeast(1)).setTypeOfLesion(Mockito.<String>any());
    verify(cancerGynecologicalExamination).setTypeOfLesionList(Mockito.<List<String>>any());
    verify(cancerGynecologicalExamination).setUterus_Normal(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVaginalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setVanID(Mockito.<Integer>any());
    verify(cancerGynecologicalExamination).setVanSerialNo(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVehicalNo(eq("Vehical No"));
    verify(cancerGynecologicalExamination).setVisitCode(Mockito.<Long>any());
    verify(cancerGynecologicalExamination).setVulvalInvolvement(Mockito.<Boolean>any());
    verify(cancerGynecologicalExamination).setrTIOrSTIDetail(eq("R TIOr STIDetail"));
    verify(cancerGynecologicalExaminationRepo).updateCancerGynecologicalExamination(Mockito.<Integer>any(),
        eq("Appearance Of Cervix"), eq("Type Of Lesion"), Mockito.<Boolean>any(), Mockito.<Boolean>any(),
        Mockito.<Boolean>any(), Mockito.<Boolean>any(), eq("Getr TIOr STIDetail"), eq("/directory/foo.txt"),
        Mockito.<Boolean>any(), eq("Observation"), eq("Jan 1, 2020 9:00am GMT+0100"), Mockito.<Long>any(),
        Mockito.<Long>any(), eq("Processed"));
    assertEquals(1, actualUpdateCancerGynecologicalExaminationResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails() {
    // Arrange, Act and Assert
    assertEquals(1, cSNurseServiceImpl.updateCancerExamImgAnotasnDetails(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails2() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(0, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails3() {
    // Arrange
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(cancerExaminationImageAnnotationList);
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation2 = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation2.setBenVisitID(1L);
    cancerExaminationImageAnnotation2.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation2.setCancerImageID(1);
    cancerExaminationImageAnnotation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation2.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setDeleted(true);
    cancerExaminationImageAnnotation2.setID(1L);
    cancerExaminationImageAnnotation2.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation2.setParkingPlaceID(1);
    cancerExaminationImageAnnotation2.setPoint(1);
    cancerExaminationImageAnnotation2.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation2.setProcessed("Processed");
    cancerExaminationImageAnnotation2.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation2.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation2.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation2.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setVanID(1);
    cancerExaminationImageAnnotation2.setVanSerialNo(1L);
    cancerExaminationImageAnnotation2.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation2.setVisitCode(1L);
    cancerExaminationImageAnnotation2.setxCoordinate(1);
    cancerExaminationImageAnnotation2.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList2 = new ArrayList<>();
    cancerExaminationImageAnnotationList2.add(cancerExaminationImageAnnotation2);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList2);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(1, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails4() {
    // Arrange
    ArrayList<Object[]> objectArrayList = new ArrayList<>();
    objectArrayList.add(new Object[]{"42"});
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(objectArrayList);

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    assertEquals(0, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails5() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation2 = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation2.setBenVisitID(2L);
    cancerExaminationImageAnnotation2.setBeneficiaryRegID(2L);
    cancerExaminationImageAnnotation2.setCancerImageID(2);
    cancerExaminationImageAnnotation2.setCreatedBy("Created By");
    cancerExaminationImageAnnotation2.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setDeleted(false);
    cancerExaminationImageAnnotation2.setID(2L);
    cancerExaminationImageAnnotation2.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setModifiedBy("Modified By");
    cancerExaminationImageAnnotation2.setParkingPlaceID(2);
    cancerExaminationImageAnnotation2.setPoint(0);
    cancerExaminationImageAnnotation2.setPointDesc("42");
    cancerExaminationImageAnnotation2.setProcessed("42");
    cancerExaminationImageAnnotation2.setProviderServiceMapID(2);
    cancerExaminationImageAnnotation2.setReservedForChange("42");
    cancerExaminationImageAnnotation2.setSyncedBy("42");
    cancerExaminationImageAnnotation2.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setVanID(2);
    cancerExaminationImageAnnotation2.setVanSerialNo(0L);
    cancerExaminationImageAnnotation2.setVehicalNo("42");
    cancerExaminationImageAnnotation2.setVisitCode(0L);
    cancerExaminationImageAnnotation2.setxCoordinate(0);
    cancerExaminationImageAnnotation2.setyCoordinate(0);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation2);
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(0, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails6() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getyCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getVisitCode()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotation).getBeneficiaryRegID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCancerImageID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCreatedBy();
    verify(cancerExaminationImageAnnotation).getVisitCode();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).getyCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation, atLeast(1)).setModifiedBy(Mockito.<String>any());
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(0, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails7() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(null);
    when(cancerExaminationImageAnnotation.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getVisitCode()).thenReturn(1L);
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotation).getBeneficiaryRegID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getVisitCode();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(1, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails8() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getyCoordinate()).thenReturn(null);
    when(cancerExaminationImageAnnotation.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getVisitCode()).thenReturn(1L);
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotation).getBeneficiaryRegID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getVisitCode();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).getyCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(1, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails9() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getyCoordinate()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getBeneficiaryRegID()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getVisitCode()).thenReturn(1L);
    when(cancerExaminationImageAnnotation.getCreatedBy()).thenReturn(null);
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotation).getBeneficiaryRegID();
    verify(cancerExaminationImageAnnotation, atLeast(1)).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getCreatedBy();
    verify(cancerExaminationImageAnnotation).getVisitCode();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).getyCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(1, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Method under test:
   * {@link CSNurseServiceImpl#updateCancerExamImgAnotasnDetails(List)}
   */
  @Test
  void testUpdateCancerExamImgAnotasnDetails10() {
    // Arrange
    when(cancerExaminationImageAnnotationRepo.saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any()))
        .thenReturn(new ArrayList<>());
    when(cancerExaminationImageAnnotationRepo.getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any())).thenReturn(new ArrayList<>());
    CancerExaminationImageAnnotation cancerExaminationImageAnnotation = mock(CancerExaminationImageAnnotation.class);
    when(cancerExaminationImageAnnotation.getCancerImageID()).thenReturn(1);
    when(cancerExaminationImageAnnotation.getxCoordinate()).thenReturn(null);
    doNothing().when(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    doNothing().when(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setModifiedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setPointDesc(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProcessed(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setReservedForChange(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedBy(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setVehicalNo(Mockito.<String>any());
    doNothing().when(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    doNothing().when(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    doNothing().when(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    cancerExaminationImageAnnotation.setBenVisitID(1L);
    cancerExaminationImageAnnotation.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation.setCancerImageID(1);
    cancerExaminationImageAnnotation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setDeleted(true);
    cancerExaminationImageAnnotation.setID(1L);
    cancerExaminationImageAnnotation.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation.setParkingPlaceID(1);
    cancerExaminationImageAnnotation.setPoint(1);
    cancerExaminationImageAnnotation.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation.setProcessed("Processed");
    cancerExaminationImageAnnotation.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation.setVanID(1);
    cancerExaminationImageAnnotation.setVanSerialNo(1L);
    cancerExaminationImageAnnotation.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation.setVisitCode(1L);
    cancerExaminationImageAnnotation.setxCoordinate(1);
    cancerExaminationImageAnnotation.setyCoordinate(1);

    CancerExaminationImageAnnotation cancerExaminationImageAnnotation2 = new CancerExaminationImageAnnotation();
    cancerExaminationImageAnnotation2.setBenVisitID(1L);
    cancerExaminationImageAnnotation2.setBeneficiaryRegID(1L);
    cancerExaminationImageAnnotation2.setCancerImageID(1);
    cancerExaminationImageAnnotation2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    cancerExaminationImageAnnotation2.setCreatedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setDeleted(false);
    cancerExaminationImageAnnotation2.setID(1L);
    cancerExaminationImageAnnotation2.setLastModDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
    cancerExaminationImageAnnotation2.setParkingPlaceID(1);
    cancerExaminationImageAnnotation2.setPoint(1);
    cancerExaminationImageAnnotation2.setPointDesc("Point Desc");
    cancerExaminationImageAnnotation2.setProcessed("Processed");
    cancerExaminationImageAnnotation2.setProviderServiceMapID(1);
    cancerExaminationImageAnnotation2.setReservedForChange("Reserved For Change");
    cancerExaminationImageAnnotation2.setSyncedBy("Synced By");
    cancerExaminationImageAnnotation2.setSyncedDate(mock(Timestamp.class));
    cancerExaminationImageAnnotation2.setVanID(1);
    cancerExaminationImageAnnotation2.setVanSerialNo(1L);
    cancerExaminationImageAnnotation2.setVehicalNo("Vehical No");
    cancerExaminationImageAnnotation2.setVisitCode(1L);
    cancerExaminationImageAnnotation2.setxCoordinate(1);
    cancerExaminationImageAnnotation2.setyCoordinate(1);

    ArrayList<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = new ArrayList<>();
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation2);
    cancerExaminationImageAnnotationList.add(cancerExaminationImageAnnotation);

    // Act
    int actualUpdateCancerExamImgAnotasnDetailsResult = cSNurseServiceImpl
        .updateCancerExamImgAnotasnDetails(cancerExaminationImageAnnotationList);

    // Assert
    verify(cancerExaminationImageAnnotation).getCancerImageID();
    verify(cancerExaminationImageAnnotation).getxCoordinate();
    verify(cancerExaminationImageAnnotation).setBenVisitID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setBeneficiaryRegID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setCancerImageID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setCreatedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setDeleted(Mockito.<Boolean>any());
    verify(cancerExaminationImageAnnotation).setID(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setLastModDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
    verify(cancerExaminationImageAnnotation).setParkingPlaceID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPoint(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setPointDesc(eq("Point Desc"));
    verify(cancerExaminationImageAnnotation).setProcessed(eq("Processed"));
    verify(cancerExaminationImageAnnotation).setProviderServiceMapID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setReservedForChange(eq("Reserved For Change"));
    verify(cancerExaminationImageAnnotation).setSyncedBy(eq("Synced By"));
    verify(cancerExaminationImageAnnotation).setSyncedDate(Mockito.<Timestamp>any());
    verify(cancerExaminationImageAnnotation).setVanID(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setVanSerialNo(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setVehicalNo(eq("Vehical No"));
    verify(cancerExaminationImageAnnotation).setVisitCode(Mockito.<Long>any());
    verify(cancerExaminationImageAnnotation).setxCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotation).setyCoordinate(Mockito.<Integer>any());
    verify(cancerExaminationImageAnnotationRepo).getCancerExaminationImageAnnotationDetailsStatus(Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<Integer>>any());
    verify(cancerExaminationImageAnnotationRepo).saveAll(Mockito.<Iterable<CancerExaminationImageAnnotation>>any());
    assertEquals(0, actualUpdateCancerExamImgAnotasnDetailsResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>
   * {@link CSNurseServiceImpl#setBenCancerVitalDetailRepo(BenCancerVitalDetailRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setBenFamilyCancerHistoryRepo(BenFamilyCancerHistoryRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setBenObstetricCancerHistoryRepo(BenObstetricCancerHistoryRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setBenPersonalCancerDietHistoryRepo(BenPersonalCancerDietHistoryRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setBenPersonalCancerHistoryRepo(BenPersonalCancerHistoryRepo)}
   *   <li>{@link CSNurseServiceImpl#setBenVisitDetailRepo(BenVisitDetailRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerAbdominalExaminationRepo(CancerAbdominalExaminationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerBreastExaminationRepo(CancerBreastExaminationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerExaminationImageAnnotationRepo(CancerExaminationImageAnnotationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerGynecologicalExaminationRepo(CancerGynecologicalExaminationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerLymphNodeExaminationRepo(CancerLymphNodeExaminationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerOralExaminationRepo(CancerOralExaminationRepo)}
   *   <li>
   * {@link CSNurseServiceImpl#setCancerSignAndSymptomsRepo(CancerSignAndSymptomsRepo)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     CSNurseServiceImpl.benCancerVitalDetailRepo
    //     CSNurseServiceImpl.benFamilyCancerHistoryRepo
    //     CSNurseServiceImpl.benObstetricCancerHistoryRepo
    //     CSNurseServiceImpl.benPersonalCancerDietHistoryRepo
    //     CSNurseServiceImpl.benPersonalCancerHistoryRepo
    //     CSNurseServiceImpl.benVisitDetailRepo
    //     CSNurseServiceImpl.cancerAbdominalExaminationRepo
    //     CSNurseServiceImpl.cancerBreastExaminationRepo
    //     CSNurseServiceImpl.cancerExaminationImageAnnotationRepo
    //     CSNurseServiceImpl.cancerGynecologicalExaminationRepo
    //     CSNurseServiceImpl.cancerLymphNodeExaminationRepo
    //     CSNurseServiceImpl.cancerOralExaminationRepo
    //     CSNurseServiceImpl.cancerSignAndSymptomsRepo
    //     CSNurseServiceImpl.logger

    // Arrange
    CSNurseServiceImpl csNurseServiceImpl = new CSNurseServiceImpl();

    // Act
    csNurseServiceImpl.setBenCancerVitalDetailRepo(mock(BenCancerVitalDetailRepo.class));
    csNurseServiceImpl.setBenFamilyCancerHistoryRepo(mock(BenFamilyCancerHistoryRepo.class));
    csNurseServiceImpl.setBenObstetricCancerHistoryRepo(mock(BenObstetricCancerHistoryRepo.class));
    csNurseServiceImpl.setBenPersonalCancerDietHistoryRepo(mock(BenPersonalCancerDietHistoryRepo.class));
    csNurseServiceImpl.setBenPersonalCancerHistoryRepo(mock(BenPersonalCancerHistoryRepo.class));
    csNurseServiceImpl.setBenVisitDetailRepo(mock(BenVisitDetailRepo.class));
    csNurseServiceImpl.setCancerAbdominalExaminationRepo(mock(CancerAbdominalExaminationRepo.class));
    csNurseServiceImpl.setCancerBreastExaminationRepo(mock(CancerBreastExaminationRepo.class));
    csNurseServiceImpl.setCancerExaminationImageAnnotationRepo(mock(CancerExaminationImageAnnotationRepo.class));
    csNurseServiceImpl.setCancerGynecologicalExaminationRepo(mock(CancerGynecologicalExaminationRepo.class));
    csNurseServiceImpl.setCancerLymphNodeExaminationRepo(mock(CancerLymphNodeExaminationRepo.class));
    csNurseServiceImpl.setCancerOralExaminationRepo(mock(CancerOralExaminationRepo.class));
    csNurseServiceImpl.setCancerSignAndSymptomsRepo(mock(CancerSignAndSymptomsRepo.class));
  }
}
