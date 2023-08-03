
import java.util.HashSet;
import java.util.Set;

class BloodBank{
    private String bloodBankID;
    private String bloodBankName;
    private Set<Donor> Donors= new HashSet<>();

    public BloodBank(String bloodBankID, String bloodBankName) {
        this.bloodBankID = bloodBankID;
        this.bloodBankName = bloodBankName;
    }

    public boolean addNewDonor(Donor newDonor){
        if(Donors.contains(newDonor)){
            return false;
        }else{
            Donors.add(newDonor);
            return true;
        }
    }

    public Donor getDonorDetails(String donorID){
        for(Donor dn: Donors){
            if(dn.getDonarID() == donorID){
                return dn;
            }
        }
        return null;
    }

    public boolean updateDonor(Donor updateDonor){
       for(Donor dn: Donors){
           if(dn.getDonarID()== updateDonor.getDonarID()){
               dn.setPhone(updateDonor.getPhone());
               return true;
           }
       }
       return false;
    }



    public boolean deleteDonor(String donorID){
        for(Donor dn: Donors){
            if(dn.getDonarID() == donorID){
                Donors.remove(dn);
                return true;
            }
        }
        return false;
    }



    public Set<Donor> getDonors(String bloodGroup){
        Set<Donor> dummy = new HashSet<>();
        for(Donor dn: Donors){
            if(dn.getBloodGroup()==bloodGroup){
                dummy.add(dn);
            }
        }
        return dummy;
    }
}

public class Main {
    public static void main(String[] args) {
        BloodBank bloodBank = new BloodBank("abc","AAAAA");

        bloodBank.addNewDonor(new Donor("D123","abc","1234567","B+"));
        bloodBank.addNewDonor(new Donor("D124","bbb","1253467","A+"));
        bloodBank.addNewDonor(new Donor("D126","ccc","36715426","A"));
        bloodBank.addNewDonor(new Donor("D127","ddd","5683546","B"));
        bloodBank.addNewDonor(new Donor("D456","adf","9876535","B+"));
        bloodBank.addNewDonor(new Donor("D354","hfg","0965432","B+"));
        bloodBank.addNewDonor(new Donor("D175","qwe","4231534","B+"));

        for(Donor dn:bloodBank.getDonors("B+")){
            System.out.println(dn.getDonarName()+":"+dn.getBloodGroup());
        }

        System.out.println(bloodBank.updateDonor(new Donor("D127","ddd", "5683546","A+")));
    }
}