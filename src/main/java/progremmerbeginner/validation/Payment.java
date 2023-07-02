package progremmerbeginner.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import progremmerbeginner.Enum.CaseMode;
import progremmerbeginner.constraint.CheckCase;
import progremmerbeginner.constraint.CheckOrderId;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.group.PaymentGroup;
import progremmerbeginner.group.VirtualAccountPaymentGroup;
import progremmerbeginner.payload.EmailErrorMessage;

public class Payment {
    @CheckOrderId(groups = {VirtualAccountPaymentGroup.class,CreditCardPaymentGroup.class},message = "{order.id.invalid}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},message = "{amount.notnull}")
    @Range(groups ={CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L,max = 100_000_000L,message = "{amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class},message = "credit card must not blank")
    @LuhnCheck(payload = {EmailErrorMessage.class},groups = {CreditCardPaymentGroup.class},message = "invalid credit card number")
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},message = "virtual account must not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},message = "customers can not blank")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class ,to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class ,to = Default.class)
    private Customers customers;
    public Payment() {

    }

    public Payment(String orderId, Long amount, String creditCard) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customers=" + customers +
                '}';
    }
}
