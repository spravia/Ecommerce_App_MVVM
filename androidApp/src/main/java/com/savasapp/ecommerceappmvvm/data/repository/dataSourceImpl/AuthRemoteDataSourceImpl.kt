import android.service.autofill.UserData
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import retrofit2.Response


class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource
{
    override suspend fun login(loginData : LoginState) =  authService.login(loginData)

    override suspend fun register(user: User) : Response<AuthResponse> = authService.register(user)

}