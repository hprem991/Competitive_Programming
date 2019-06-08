//Prem : June 2019 Amazon Failure Question

// Filtering System 

// Recommendation System
class CustomerName {
	String firstName;
	String lastName;
}

class Review {
	enum Ratings {NO_STAR, ONE_STAR, TWO_STAR, THREE_STAR, FOUR_STAR, FIVE_STAR}
	
	Ratings m_rate;
	CustomerName m_reviewer;
	String m_review;
}

//This is a design decision whether to have a Product Category inside Product or reverse
class ProductCategory {
	String m_category;
}

class Product {
	String m_productID;
	ProductCategory m_productcategory;
	double m_weight; // There should be a Logic to Calulate this may be everytime we add a New Review
	// Interfaces
}



class ReviewSystem<Ratings> {
	// Have a proper Understanding about the followin DS
	Map<Product, // For each product
		TreeMap<Ratings, // Categories of Rating, remember TreeMap for Sorted order
			ArrayList<Review>>> m_productReview;
	
	Map<Ratings, ArrayList<Review>> getReviewofProduct(Product aProduct) {
		if(m_productReview.containsKey(aProduct)) {
			return m_productReview.get(aProduct);
		}
	}
	
	void addReview(Product aProduct, Review aReview) {
		if(m_productReview.containsKey(aProduct)) {
			Map<Ratings, ArrayList<Review>> review = m_productReview.get(aProduct);
			if(review.containsKey(aReview.m_rate)) {
				ArrayList<Review> a_review = review.get(aReview.m_rate);
				a_review.add(aReview);
				review.put(aReview.m_rate, a_review);
			} else  {
				review.put(aReview.m_rate, aReview);
			}
			m_productReview.put(aProduct, review);
		} else {
			m_productReview.put(aProduct, aReview);
		}
	}
}

class RecommendationSystem {
	ArrayList<Product> getRecommendation(Product aProduct, Ratings aRatings) {
		ArrayList<Product> recommendationList = new ArrayList<Product>();
		
		// Let DB do the job of running SQL to get all the products of this category coz SQL / DB is faster
		ArrayList<Product>  allProduct  = MyDb.getAllProduct(new SQL(new String("select Products from Product where Product.category "+aProduct.m_productcategory+" asc "+aProduct.m_weight)));
		ReviewSystem reviews = new ReviewSystem();
		for(int i = 0; i < allProduct.size(); i++) {
			TreeMap<Ratings, ArrayList<Review>> review = reviews.getReviewofProduct(allProduct.get(i));
			for(Map.Entry<Ratings, ArrayList<Review>> entry : review.entrySet()) {
				if(aRatings != null) {//if user has invoked with a particular ratings filter
					if(entry.getKey() == aRatings /*|| entry.getKey() >= aRatings*/) { // This can be switch where all rating above certain category can be added
						  //If we were to invoke a logic for weight here, it will be slow but here is where we can do
						  //if (LOGIC) { 
								// Do Something
						  //}
						// Calculate the weighted Average or the DB has to have this calculated evertime we add the value
						recommendationList.add(allProduct.get(i));
					} // else keep looking for next filter and so on
				} else { // No Filter Provided
					// We simply add the products
					recommendationList.add(allProduct.get(i));
				}
			}
		}
		return recommendationList;
	}
}


