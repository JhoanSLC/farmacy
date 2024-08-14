package com.farmacy.medicine.infrastructure.controller;

import com.farmacy.medicine.application.*;
import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;
import com.farmacy.medicine.infrastructure.repository.MedicineRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MedicineController {
    private final MedicineService medicineService;
    private final CreateMedicineUC createMedicineUC;
    private final DeleteMedicineUC deleteMedicineUC;
    private final FindMedicineByIdUC findMedicineByIdUC;
    private final UpdateMedicineUC updateMedicineUC;
    private final ListAllMedicinesUC listAllMedicinesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public MedicineController() {
        this.medicineService = new MedicineRepository();
        this.createMedicineUC = new CreateMedicineUC(medicineService);
        this.deleteMedicineUC = new DeleteMedicineUC(medicineService);
        this.findMedicineByIdUC = new FindMedicineByIdUC(medicineService);
        this.updateMedicineUC = new UpdateMedicineUC(medicineService);
        this.listAllMedicinesUC = new ListAllMedicinesUC(medicineService);
    }

    public void createMedicine() {
        screen.clean();
        System.out.println("Type the name of the medicine");
        String nameMedicine = scan.nextLine();
        System.out.println("Type the proceedings code");
        String proceedings = scan.nextLine();
        System.out.println("Type the health register");
        String healthRegister = scan.nextLine();
        System.out.println("Type the short description");
        String descriptionShort = scan.nextLine();
        System.out.println("Type the long description");
        String descriptionLong = scan.nextLine();
        System.out.println("Type the mode administration code");
        int codeModeAdmin = Integer.parseInt(scan.nextLine());
        System.out.println("Type the active principle code");
        int codeAp = Integer.parseInt(scan.nextLine());
        System.out.println("Type the unit measurement code");
        int codeUm = Integer.parseInt(scan.nextLine());
        System.out.println("Type the role name");
        String nameRol = scan.nextLine();
        System.out.println("Type the lab code");
        int codeLab = Integer.parseInt(scan.nextLine());

        Medicine medicine = new Medicine();
        medicine.setProceedings(proceedings);
        medicine.setNameMedicine(nameMedicine);
        medicine.setHealthRegister(healthRegister);
        medicine.setDescriptionShort(descriptionShort);
        medicine.setDescriptionLong(descriptionLong);
        medicine.setCodeModeAdmin(codeModeAdmin);
        medicine.setCodeAp(codeAp);
        medicine.setCodeUm(codeUm);
        medicine.setNameRol(nameRol);
        medicine.setCodeLab(codeLab);

        createMedicineUC.create(medicine);
        screen.pause();
    }

    public void deleteMedicine() {
        screen.clean();
        System.out.println("Type the ID of the medicine you want to delete");
        int id = Integer.parseInt(scan.nextLine());
        deleteMedicineUC.delete(id);
        System.out.println("Succesfully deleted!!");
        screen.pause();
    }

    public void findMedicineById() {
        screen.clean();
        System.out.println("Type the ID of the medicine you want to see");
        int id = Integer.parseInt(scan.nextLine());
        Optional<Medicine> medicine = findMedicineByIdUC.findById(id);

        medicine.ifPresentOrElse(
            m -> {
                System.out.printf(
                "ID: %d%nProceedings: %s%nName: %s%nHealth Register: %s%nDescription Long: %s%nDescription Short: %s%n" +
                "Mode Administration Code: %d%nActive Principle Code: %d%nUnit Measurement Code: %d%nRole Name: %s%nLab Code: %d%n",
                m.getId(),
                m.getProceedings(),
                m.getNameMedicine(),
                m.getHealthRegister(),
                m.getDescriptionLong(),
                m.getDescriptionShort(),
                m.getCodeModeAdmin(),
                m.getCodeAp(),
                m.getCodeUm(),
                m.getNameRol(),
                m.getCodeLab()
            );
            },
            
            () -> System.out.println("Medicine not found.")
        );
        screen.pause();
    }

    public void updateMedicine() {
        screen.clean();
        System.out.println("Type the ID of the medicine you want to update");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Type the new name for this medicine");
        String nameMedicine = scan.nextLine();
        System.out.println("Type the new short description");
        String descriptionShort = scan.nextLine();
        System.out.println("Type the new long description");
        String descriptionLong = scan.nextLine();
        updateMedicineUC.update(id, nameMedicine, descriptionShort, descriptionLong);
    }

    public void listAllMedicines() {
        screen.clean();
        System.out.println("Listing all medicines:");
        List<Medicine> medicines = listAllMedicinesUC.listAll();

        if (medicines.isEmpty()) {
            System.out.println("No medicines found.");
        } else {
            for (Medicine medicine : medicines) {
                System.out.println("");
                System.out.printf(
                    "ID: %d%nProceedings: %s%nName: %s%nHealth Register: %s%nDescription Long: %s%nDescription Short: %s%n" +
                    "Mode Administration Code: %d%nActive Principle Code: %d%nUnit Measurement Code: %d%nRole Name: %s%nLab Code: %d%n",
                    medicine.getId(),
                    medicine.getProceedings(),
                    medicine.getNameMedicine(),
                    medicine.getHealthRegister(),
                    medicine.getDescriptionLong(),
                    medicine.getDescriptionShort(),
                    medicine.getCodeModeAdmin(),
                    medicine.getCodeAp(),
                    medicine.getCodeUm(),
                    medicine.getNameRol(),
                    medicine.getCodeLab()
                );
                System.out.println("---------------------------------------");

            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
