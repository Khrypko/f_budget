package ua.com.khrypko.family.budget.service.user.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by max on 06.01.17.
 */
public class TemporaryUserContainer {

    private volatile Map<String, RegistrationRequest> registrationRequests;
    private volatile Map<String, PasswordResetRequest> passwordResetRequests;
    private volatile Map<String, PasswordResetRequest> contractorPasswordResetRequests;

    public TemporaryUserContainer() {
        this.registrationRequests = new HashMap<>();
        this.passwordResetRequests = new HashMap<>();
        this.contractorPasswordResetRequests = new HashMap<>();
    }

    public RegistrationRequest getRegistrationRequest(String temporaryRegistrationUrl){
        return registrationRequests.get(temporaryRegistrationUrl);
    }

    public synchronized void addRegistrationRequest(String temporaryRegistrationUrl, RegistrationRequest registrationRequest){
        registrationRequests.put(temporaryRegistrationUrl, registrationRequest);
    }

    public synchronized void removeRegistrationRequest(String temporaryRegistrationUrl){
        registrationRequests.remove(temporaryRegistrationUrl);
    }

    public PasswordResetRequest getPassworResetRequest(String passwordResetUrl){
        return passwordResetRequests.get(passwordResetUrl);
    }

    public synchronized void addPasswordResetRequest(String temporaryPasswordUrl, PasswordResetRequest passwordResetRequest){
        passwordResetRequests.put(temporaryPasswordUrl, passwordResetRequest);
    }

    public synchronized void removePasswordResetRequest(String temporaryPasswordResetUrl){
        passwordResetRequests.remove(temporaryPasswordResetUrl);
    }



    public PasswordResetRequest getContractorPassworResetRequest(String passwordResetUrl){
        return contractorPasswordResetRequests.get(passwordResetUrl);
    }

    public synchronized void addContractorPasswordResetRequest(String temporaryPasswordUrl, PasswordResetRequest passwordResetRequest){
        contractorPasswordResetRequests.put(temporaryPasswordUrl, passwordResetRequest);
    }

    public synchronized void removeContractorPasswordResetRequest(String temporaryPasswordResetUrl){
        contractorPasswordResetRequests.remove(temporaryPasswordResetUrl);
    }



    public synchronized void removeRegistrationRequest(RegistrationRequest registrationRequest){
        for (Map.Entry<String, RegistrationRequest> entry : registrationRequests.entrySet())
            if (entry.getValue().equals(registrationRequest)){
                registrationRequests.remove(entry.getKey());
                break;
            }
    }

    public synchronized void removeRequest(String temporaryUrl){
        passwordResetRequests.remove(temporaryUrl);
        registrationRequests.remove(temporaryUrl);
    }

    public List<RegistrationRequest> getAllCurrentRequests(){
        List<RegistrationRequest> returnList = registrationRequests.entrySet().stream().map(Map.Entry<String, RegistrationRequest>::getValue).collect(Collectors.toList());

        return returnList;
    }

    public List<PasswordResetRequest> getAllPasswordResetRequests(){
        List<PasswordResetRequest> returnList = passwordResetRequests.entrySet().stream().map(Map.Entry<String, PasswordResetRequest>::getValue).collect(Collectors.toList());

        return returnList;
    }

    public List<PasswordResetRequest> getContractorPasswordResetRequests(){
        List<PasswordResetRequest> returnList = contractorPasswordResetRequests.entrySet().stream().map(Map.Entry<String, PasswordResetRequest>::getValue).collect(Collectors.toList());

        return returnList;
    }

    /**
     *
     * @return Возвращает все запросы (и на регистрацию, и на смену пароля)
     */
    public List<AbstractRegistrationRequest> getAllRequests(){
        List<AbstractRegistrationRequest> returnList = new ArrayList<>(getAllCurrentRequests());
        returnList.addAll(getAllPasswordResetRequests());
        returnList.addAll(getContractorPasswordResetRequests());
        return returnList;
    }
}
