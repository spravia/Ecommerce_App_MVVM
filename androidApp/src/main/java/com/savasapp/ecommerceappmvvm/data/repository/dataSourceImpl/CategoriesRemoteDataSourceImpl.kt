
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.CategoryService
import com.savasapp.ecommerceappmvvm.domain.model.Category
import retrofit2.Response


//import java.io.File


class CategoriesRemoteDataSourceImpl(private val categoryService: CategoryService) : CategoriesRemoteDataSource
{
    override suspend fun create(category: Category): Response<Category> = categoryService.create(category)

    override suspend fun getCategories(): Response<List<Category>> = categoryService.getCategories()

    override suspend fun update(id: Int, category: Category): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Response<Category> {
        TODO("Not yet implemented")
    }


}