import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState


class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource
{
    override suspend fun login(loginData : LoginState) =  authService.login(loginData)
       // , password

}