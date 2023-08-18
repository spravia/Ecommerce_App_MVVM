import android.service.autofill.UserData
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.data.service.UserService
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import retrofit2.Response


class UsersRemoteDataSourceImpl(private val userService: UserService) : UsersRemoteDataSource
{
    override suspend fun update(user: User): Response<User> = userService.update(user.id ?: 0 ,user)

}