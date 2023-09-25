import React from 'react';
import { useFeedback } from './context/FeedbackContext';

const AdminFeedbacks = () => {
    const { reviews } = useFeedback();
  return (
    <div className="admin-feedbacks">
      <h1>Admin Feedbacks</h1>
      <div className="feedback-list">
        {reviews.map((review, index) => (
          <div className={`feedback-item ${index % 2 === 0 ? 'even-review' : 'odd-review'}`} key={index}>
            <h2>Review by {review.customerName}</h2>
            <div className="star-rating">
              {renderStars(review.rating)}
            </div>
            <p>{review.comment}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

// Helper function to render star ratings
const renderStars = (rating) => {
  const stars = [];
  for (let i = 0; i < rating; i++) {
    stars.push(<span key={i} className="star filled">&#9733;</span>);
  }
  for (let i = rating; i < 5; i++) {
    stars.push(<span key={i} className="star">&#9733;</span>);
  }
  return stars;
};

export default AdminFeedbacks;
