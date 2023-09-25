import { createContext, useContext, useState, useEffect } from 'react';

const FeedbackContext = createContext();

export const useFeedback = () => useContext(FeedbackContext);

export const FeedbackProvider = ({ children }) => {
  const [reviews, setReviews] = useState(() => {
    // Initialize with the reviews stored in local storage, or an empty array if none exists.
    const storedReviews = localStorage.getItem('reviews');
    return storedReviews ? JSON.parse(storedReviews) : [];
  });

  // Use useEffect to keep local storage in sync with the reviews state.
  useEffect(() => {
    localStorage.setItem('reviews', JSON.stringify(reviews));
  }, [reviews]);

  const addReview = (review) => {
    setReviews([...reviews, review]);
  };

  return (
    <FeedbackContext.Provider value={{ reviews, addReview }}>
      {children}
    </FeedbackContext.Provider>
  );
};
