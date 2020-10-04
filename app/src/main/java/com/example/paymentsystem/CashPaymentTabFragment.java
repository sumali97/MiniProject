import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CashPaymentTabFragment extends Fragment {

    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.cash_payment_tab_fragment, container, false);

        View name = viewGroup.findViewById(R.id.cash_name);
        View phone = viewGroup.findViewById(R.id.cash_phoneNo);
        View province = viewGroup.findViewById(R.id.cash_province);
        View district = viewGroup.findViewById(R.id.cash_district);
        View city = viewGroup.findViewById(R.id.cash_city);
        View address = viewGroup.findViewById(R.id.cash_address);
        View button = viewGroup.findViewById(R.id.cash_btn_save);

        name.setTranslationX(800);
        phone.setTranslationX(800);
        province.setTranslationX(800);
        district.setTranslationX(800);
        city.setTranslationX(800);
        address.setTranslationX(800);
        button.setTranslationX(800);

        name.setAlpha(v);
        phone.setAlpha(v);
        province.setAlpha(v);
        district.setAlpha(v);
        city.setAlpha(v);
        address.setAlpha(v);
        button.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        phone.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        province.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        district.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        city.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        address.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();


        return viewGroup;








    }
}
