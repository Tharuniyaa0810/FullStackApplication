import React, { useState } from 'react';
import classNames from 'classnames';
import '../assets/css/Feedback.css'
import StarRating from './StarRating'; // Import the StarRating component

const FeedbackPage = () => {
  const [reviews, setReviews] = useState([]);
  const [formData, setFormData] = useState({
    name: '',
    rating: 5, // Default rating is 5 stars
    comment: '',
  });

  const handleFormSubmit = (e) => {
    e.preventDefault();

    // Create a new review object
    const newReview = {
      name: formData.name,
      rating: formData.rating,
      comment: formData.comment,
    };

    // Add the new review to the reviews array
    setReviews([...reviews, newReview]);

    // Clear the form
    setFormData({
      name: '',
      rating: 5, // Reset the rating to 5 stars
      comment: '',
    });
  };

  return (
    <div className="feedback-container">
      <header className="feedback-header">
        <h1>Feedback Page</h1>
      </header>
      <main className='feedback-main'>
        <section className="feedback-form">
          <h2>Leave Your Feedback</h2>
          <form onSubmit={handleFormSubmit}>
            <div className="form-group">
              <label className="label" htmlFor="name">
                Name:
              </label>
              <input
                className="input"
                type="text"
                id="name"
                name="name"
                value={formData.name}
                onChange={(e) =>
                  setFormData({ ...formData, name: e.target.value })
                }
                required
              />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="rating">
                Rating:
              </label>
              <StarRating
                rating={formData.rating}
                onRatingChange={(newRating) =>
                  setFormData({ ...formData, rating: newRating })
                }
              />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="comment">
                Comment:
              </label>
              <textarea
                className="textarea"
                id="comment"
                name="comment"
                rows="4"
                value={formData.comment}
                onChange={(e) =>
                  setFormData({ ...formData, comment: e.target.value })
                }
                required
              ></textarea>
            </div>
            <button className="submit-button" type="submit">
              Submit
            </button>
          </form>
        </section>
        <section className="reviews">
          <h2>Customer Reviews</h2>
          <ul>
            {reviews.map((review, index) => (
              <li
                key={index}
                className={classNames('review-item', {
                  'odd-review': index % 2 === 0,
                })}
              >
                <h3>
                  {review.name} - Rating: {review.rating}
                </h3>
                <p>{review.comment}</p>
              </li>
            ))}
          </ul>
        </section>
      </main>
    </div>
  );
};

export default FeedbackPage;
